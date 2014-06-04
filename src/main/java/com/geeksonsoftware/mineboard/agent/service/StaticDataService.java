package com.geeksonsoftware.mineboard.agent.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class StaticDataService {

	public static int DEFAULT_TIME_INTERVAL = 15;
	private static Properties properties = null;
	private static Logger log = Logger.getLogger(StaticDataService.class);

	public static String getWebsiteUrl() {
		if (System.getProperty("dev") != null) {
			log.debug("Development mode, returning local URL");
			return "http://localhost:3000/api/dashboard/";
		}
		String url = getProperties().getProperty("url");
		return url != null ? url : "https://mineboard.io/api/dashboard/";
	}

	private static Properties getProperties() {
		if (properties == null) {

			properties = new Properties();
			InputStream input = null;

			try {
				input = StaticDataService.class
						.getResourceAsStream("/config.properties");
				if (input != null) {
					properties.load(input);
				}
			} catch (IOException ex) {
				log.error("Unable to load properties!", ex);
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return properties;
	}
}
