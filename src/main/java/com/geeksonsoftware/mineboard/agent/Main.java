package com.geeksonsoftware.mineboard.agent;

import java.io.OutputStreamWriter;
import java.util.Timer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.service.JsonService;
import com.geeksonsoftware.mineboard.agent.service.TimerTaskUpdate;

public final class Main {

	private static Logger log = Logger.getLogger(Main.class);
	private static JsonService jsonService = new JsonService();

	public static void main(String[] args) {

		Configuration configuration = jsonService.loadConfiguration();

		Options options = new Options();

		options.addOption("l", "level", true,
				"choose output level between ERR/WARN/INFO/DEBUG/TRACE");

		options.addOption("t", "target", true,
				"choose target URL to submit data");

		options.addOption("s", "show-config", false,
				"show current configuration and exits");

		options.addOption("h", "help", false, "print this message");

		CommandLineParser parser = new PosixParser();
		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("l")) {
				String level = cmd.getOptionValue("level");
				Level newLevel = Level.toLevel(level);
				LogManager.getRootLogger().removeAllAppenders();
				LogManager.getRootLogger().setLevel(newLevel);
				ConsoleAppender ca = new ConsoleAppender();
				ca.setWriter(new OutputStreamWriter(System.out));
				ca.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
				LogManager.getRootLogger().addAppender(ca);
				log.info("Changed debug level to " + newLevel.toString());
			}
			if (cmd.hasOption("h")) {
				HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("mineboard-agent", options);
				return;
			}
			if (cmd.hasOption("s")) {
				if (configuration == null) {
					System.out
							.println("Configuration is empty! Please configure the agent through the config.json file!");
				} else {
					System.out.println(configuration.toString());
				}
				return;
			}
		} catch (ParseException e1) {
			log.error("Failed to parse console parameters", e1);
		}

		log.debug("Starting!");

		if (configuration == null) {
			log.error("Configuration not found or empty!");
			return;
		}

		if (configuration.getMiners() == null
				|| configuration.getMiners().size() < 1) {
			log.error("You didn't configured any miners in config.json yet!");
			return;
		}

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTaskUpdate(configuration), 0,
				configuration.getIntervalSeconds() * 1000);

		log.info("Timer started!");

		while (true) {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
