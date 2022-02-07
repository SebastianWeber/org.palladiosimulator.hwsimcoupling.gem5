package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;

public class ExtractionCommandGem5 extends CommandGem5 implements ExtractionCommand {
	
	private String methodname;
	
	public ExtractionCommandGem5(String methodname) {
		this.methodname = methodname;
	}

	@Override
	public List<String> get_command() {
		List<String> command = get_shell();
		command.add("docker");
		command.add("exec");
		command.add("gem5");
		command.add("python");
		command.add(destination_path + "extract.py");
		command.add(methodname);
		return command;
	}

}