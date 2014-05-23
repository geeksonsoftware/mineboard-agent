package com.geeksonsoftware.mineboard.agent.model;

import java.util.Arrays;
import java.util.List;

public enum MiningSoftwareName {
	CGMINER("cgminer"), BFGMiner("BFGMiner");

	private String label;

	MiningSoftwareName(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public List<MiningSoftwareName> getAsList() {
		return Arrays.asList(values());
	}

	public static MiningSoftwareName getByLabel(String input) {
		for (MiningSoftwareName name : values()) {
			if (input.equals(name.getLabel()))
				return name;
		}
		return null;
	}
}
