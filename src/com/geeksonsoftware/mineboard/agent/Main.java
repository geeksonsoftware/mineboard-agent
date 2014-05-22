package com.geeksonsoftware.mineboard.agent;

import java.util.Timer;

import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.service.ConfigurationWizard;
import com.geeksonsoftware.mineboard.agent.service.JsonService;
import com.geeksonsoftware.mineboard.agent.service.TimerTaskUpdate;

public final class Main {

	private static JsonService _jsonService = new JsonService();

	public static void main(String[] args) {
		Configuration configuration = _jsonService.loadConfiguration();
		if (configuration == null) {
			configuration = ConfigurationWizard.start();
			_jsonService.saveConfiguration(configuration);
		}

		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTaskUpdate(configuration), 0,
				5 * 1000);

		System.out.println("TimerTask started");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*configuration.setDashboardId("testId123456");

		configuration.addMiner(new MiningSoftware(MiningSoftwareName.CGMINER,
				"127.0.0.1", 4032));
		configuration.addMiner(new MiningSoftware(MiningSoftwareName.BFG,
				"127.0.0.2", 4041));
		configuration.addMiner(new MiningSoftware(MiningSoftwareName.BTCMINER,
				"127.0.0.3", 4054));*/

	}

}
