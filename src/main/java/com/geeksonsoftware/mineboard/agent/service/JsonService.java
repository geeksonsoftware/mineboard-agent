package com.geeksonsoftware.mineboard.agent.service;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.geeksonsoftware.mineboard.agent.model.Configuration;

public class JsonService {
	private static Logger log = Logger.getLogger(JsonService.class);
	private ObjectMapper _mapper = new ObjectMapper();

	public boolean saveConfiguration(Configuration configuration) {

		try {
			_mapper.writeValue(new File("config.json"), configuration);
		} catch (IOException e) {
			log.error("Unable to save configuration file to config.json", e);
			return false;
		}
		return true;

	}

	public Configuration loadConfiguration() {
		try {
			return _mapper.readValue(new File("config.json"),
					Configuration.class);
		} catch (IOException e) {
			log.error("Unable to load configuration from config.json", e);
			return null;
		}
	}
}
