package com.geeksonsoftware.mineboard.agent.service;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.geeksonsoftware.mineboard.agent.model.Configuration;

public class JsonService {

	private ObjectMapper _mapper = new ObjectMapper();

	public boolean saveConfiguration(Configuration configuration) {

		try {
			_mapper.writeValue(new File("config.json"), configuration);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public Configuration loadConfiguration() {
		try {
			return _mapper.readValue(new File("config.json"),
					Configuration.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
