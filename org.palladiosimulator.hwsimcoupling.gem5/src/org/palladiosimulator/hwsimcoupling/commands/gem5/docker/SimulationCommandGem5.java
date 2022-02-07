package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.util.List;

import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;

public class SimulationCommandGem5 extends CommandGem5 implements SimulationCommand {
	
	private String executable;
	private String system;
	private String methodname;
	private String parameters;
	
	public SimulationCommandGem5(String system, String executable, String methodname, String parameters) {
		this.executable = executable;
		this.system = system;
		this.methodname = methodname;
		this.parameters = parameters;
	}

	@Override
	public List<String> get_command() {
		List<String> command = get_shell();
		command.add("docker");
		command.add("exec");
		command.add("gem5");
		command.add("build/X86/gem5.opt");
		command.add(destination_path + system);
		command.add(executable);
		if (! ( methodname.equals("main") || methodname.equals("")) ) {
			command.add(methodname);
		}
		for (String parameter : parameters.split(" ")) {
			command.add(parameter);
		}
		return command;
	}

}
