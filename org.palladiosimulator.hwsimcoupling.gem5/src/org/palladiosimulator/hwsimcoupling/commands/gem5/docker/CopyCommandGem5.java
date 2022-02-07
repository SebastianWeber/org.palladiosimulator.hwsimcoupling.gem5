package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.io.File;
import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.CopyCommand;

public class CopyCommandGem5 extends CommandGem5 implements CopyCommand{
	
	private String source_path;
	private String destination_filename;

	public CopyCommandGem5(String source_path) {
		this.source_path = source_path;
		this.destination_filename = new File(source_path).getName();
	}
	
	public List<String> get_command(){
		List<String> command = get_shell();
		command.add("docker");
		command.add("cp");
		command.add(source_path);
		command.add("gem5:" + destination_path + destination_filename);
		return command;
	}
	
	public String get_destination() {
		return destination_filename;
	}
	

}
