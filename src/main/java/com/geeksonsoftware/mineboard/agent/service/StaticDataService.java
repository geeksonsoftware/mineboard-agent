package com.geeksonsoftware.mineboard.agent.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StaticDataService {

	public static String getWebsiteUrl() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = StaticDataService.class
					.getResourceAsStream("/config.dev.properties");
			if (input != null) {
				prop.load(input);
				String url = prop.getProperty("url");
				return url != null ? url
						: "http://localhost:3000/api/dashboard/";
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "http://localhost:3000/api/dashboard/";
	}

	public static int DEFAULT_TIME_INTERVAL = 15;

}
