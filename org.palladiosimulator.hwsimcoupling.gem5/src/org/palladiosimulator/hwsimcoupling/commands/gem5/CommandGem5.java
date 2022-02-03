package org.palladiosimulator.hwsimcoupling.commands.gem5;

import java.util.ArrayList;
import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.Command;

public abstract class CommandGem5 implements Command{

	public final String destination_path = "/usr/local/src/gem5/";
	
	public List<String> get_shell() {
		List<String> shell = new ArrayList<String>();
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		if (isWindows) {
			shell.add("cmd.exe");
			shell.add("/c");
		} else {
			shell.add("sh");
			shell.add("-c");
		}
		return shell;
	}
	
	public abstract List<String> get_command();
	
}
