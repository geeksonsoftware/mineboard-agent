package com.geeksonsoftware.mineboard.agent.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdDevs;
import com.geeksonsoftware.mineboard.agent.api.model.CgminerCmdStatus;

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
	private static Logger log = Logger.getLogger(CgminerAPI.class);

	private ObjectMapper mapper = new ObjectMapper();
	private InetAddress ip;
	private int port;

	private void closeAll() throws Exception {
		if (socket != null) {
			socket.close();
			socket = null;
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
			socket = createSocket(ip, port);
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.print("{\"command\":\"" + cmd + "\"}");
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

	public CgminerCmdStatus getStatus() {
		try {
			String result = process("summary", ip, port);
			return mapper.readValue(result, CgminerCmdStatus.class);
		} catch (Exception e) {
			log.error("Unable to retrieve data from miner", e);
			return null;
		}
	}

	public CgminerCmdDevs getDevices() {
		try {
			String result = process("devs", ip, port);
			return mapper.readValue(result, CgminerCmdDevs.class);
		} catch (Exception e) {
			log.error("Unable to retrieve devices from miner", e);
			return null;
		}
	}

	// Used for unit testing
	protected Socket createSocket(InetAddress ip, int port) throws IOException {
		return new Socket(ip, port);
	}

}
