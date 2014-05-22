package com.geeksonsoftware.mineboard.agent.service;

import static java.lang.System.out;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geeksonsoftware.mineboard.agent.model.Configuration;
import com.geeksonsoftware.mineboard.agent.model.MiningSoftware;
import com.geeksonsoftware.mineboard.agent.model.MiningSoftwareName;

public class ConfigurationWizard {
	private static final String IP_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public static Configuration start() {
		Scanner in = new Scanner(System.in);
		out.println("Seems you didn't configured the agent yet, let's do it!");

		Configuration configuration = new Configuration();

		String input = "";
		do {
			out.print("Enter the Dashboard ID: ");
			input = in.nextLine();
		} while (!validateDashboardId(input));

		configuration.setDashboardId(input);

		do {
			out.print("Enter the interval between request in seconds: ");
			input = in.nextLine();
		} while (!validateSeconds(input));

		out.println("Perfect, now let's add some mining machine");

		do {
			MiningSoftware software = askMiningSoftware();
			if (software != null) {
				configuration.addMiner(software);
			}

			out.println("Want to add another one? [y/n]:");
			do {
				input = in.nextLine();
			} while (!validateYesNo(input));

			if (input.equalsIgnoreCase("y")) {
				continue;
			} else {
				out.println("Finished!");
				break;
			}
		} while (true);

		in.close();

		return configuration;
	}

	private static boolean validateSeconds(String input) {
		try {
			int value = Integer.parseInt(input);
			return value > 0;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private static MiningSoftware askMiningSoftware() {
		Scanner in = new Scanner(System.in);

		out.println("Configuring instance");
		out.println("--------------------");

		MiningSoftware miningSoftware = new MiningSoftware();

		String input = "";
		do {
			out.print("Enter the IP: ");
			input = in.nextLine();
		} while (!validateIp(input));

		miningSoftware.setIP(input);

		do {
			out.print("Enter the port number: ");
			input = in.nextLine();
		} while (!validatePort(input));

		miningSoftware.setPort(Integer.parseInt(input));

		out.print("Please enter one of the following app: ");
		for (MiningSoftwareName name : MiningSoftwareName.values()) {
			out.print("'" + name.getLabel() + "' ");
		}
		out.print("\r\n");

		do {
			out.print("App name: ");
			input = in.nextLine();
		} while (!validateMiningApp(input));

		miningSoftware.setName(MiningSoftwareName.getByLabel(input));

		out.println("Summary:");
		out.print(miningSoftware.toString());

		do {
			out.print("Please confirm with 'y' or deny with 'n': ");
			input = in.nextLine();
		} while (!validateYesNo(input));

		in.close();

		if (input.equalsIgnoreCase("y")) {
			return miningSoftware;
		} else {
			out.println("Aborted!");
			return null;
		}

	}

	private static boolean validateYesNo(String input) {
		return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n");
	}

	private static boolean validateMiningApp(String input) {
		return MiningSoftwareName.getByLabel(input) != null;
	}

	private static boolean validatePort(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}

	}

	private static boolean validateDashboardId(String input) {
		return input != null && input.length() > 0;
	}

	private static boolean validateIp(String input) {
		Pattern pattern = Pattern.compile(IP_PATTERN);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
