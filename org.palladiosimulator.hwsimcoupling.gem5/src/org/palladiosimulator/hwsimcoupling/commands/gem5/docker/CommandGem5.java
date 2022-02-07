package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.Command;

public abstract class CommandGem5 implements Command{

	public final String destination_path = "/usr/local/src/gem5/";
	
	public abstract List<String> get_command();
	
}
