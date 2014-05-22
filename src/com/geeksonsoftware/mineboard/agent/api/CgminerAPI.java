package com.geeksonsoftware.mineboard.agent.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.geeksonsoftware.mineboard.agent.service.JsonService;

/**
 * 
 * Cgminer API service based on https://github.com/ckolivas/cgminer/blob/dbac7f53a6edf546fa263a82d58e4d9ac432889c/API.java
 * 
 * @author wizche
 *
 */
public class CgminerAPI {

	private final int MAXRECEIVESIZE = 65535;
	private Socket socket = null;
	private static Logger log = Logger.getLogger(JsonService.class);

	private InetAddress ip;
	private int port;

	private void closeAll() throws Exception {
		if (socket != null) {
			socket.close();
			socket = null;
		}
	}

	private void display(String result) throws Exception {
		String value;
		String name;
		String[] sections = result.split("\\|", 0);

		for (int i = 0; i < sections.length; i++) {
			if (sections[i].trim().length() > 0) {
				String[] data = sections[i].split(",", 0);

				for (int j = 0; j < data.length; j++) {
					String[] nameval = data[j].split("=", 2);

					if (j == 0) {
						if (nameval.length > 1
								&& Character.isDigit(nameval[1].charAt(0)))
							name = nameval[0] + nameval[1];
						else
							name = nameval[0];

						log.debug("[" + name + "] =>");
						log.debug("(");
					}

					if (nameval.length > 1) {
						name = nameval[0];
						value = nameval[1];
					} else {
						name = "" + j;
						value = nameval[0];
					}

					log.debug("   [" + name + "] => " + value);
				}
				log.debug(")");
			}
		}
	}

	private String process(String cmd, InetAddress ip, int port)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		char buf[] = new char[MAXRECEIVESIZE];
		int len = 0;

		log.debug("Attempting to send '" + cmd + "' to " + ip.getHostAddress()
				+ ":" + port);

		try {
			socket = new Socket(ip, port);
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.print(cmd.toLowerCase().toCharArray());
			ps.flush();

			InputStreamReader isr = new InputStreamReader(
					socket.getInputStream());
			while (0x80085 > 0) {
				len = isr.read(buf, 0, MAXRECEIVESIZE);
				if (len < 1)
					break;
				sb.append(buf, 0, len);
				if (buf[len - 1] == '\0')
					break;
			}

			closeAll();
		} catch (IOException ioe) {
			log.error(ioe);
			closeAll();
			return null;
		}

		String result = sb.toString();

		log.debug("Answer='" + result + "'");

		return result;
	}

	public CgminerAPI(String ip, int port) {
		try {
			this.ip = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			log.error("Unable to resolve IP: " + ip, e);
		}
		this.port = port;
	}

	public String getSummary() {
		try {
			return process("summary", ip, port);
		} catch (Exception e) {
			log.error("Unable to retrieve data from miner", e);
			return null;
		}
	}

}
