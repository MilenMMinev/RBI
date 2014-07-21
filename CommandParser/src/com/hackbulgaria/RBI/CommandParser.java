package com.hackbulgaria.RBI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

public class CommandParser {

	public static void main(String[] args) {
		
		
		CommandParser c = new CommandParser();
		System.out.println(c.getBeginLog("pwd"));
		String result = c.executeCommand("pwd");
		System.out.println(result);
		System.out.println(c.getFinishLog("pwd"));
		
	}
	
	public String getBeginLog(String cmd){
		Date d = new Date();
		return String.format("Started executing \"%s\" at: %s", cmd, d.toString());
	}
	
	public String getFinishLog(String cmd){
		Date d = new Date();
		return String.format("Finished executing \"%s\" at: %s", cmd, d.toString());
	}
	
	public String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			output.append("Unable to execute command.");
			return output.toString();
		}

		return output.toString();

	}
	
}
