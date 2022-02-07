package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import org.palladiosimulator.hwsimcoupling.commands.CopyCommand;
import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;
import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;
import org.palladiosimulator.hwsimcoupling.consumers.ErrorConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.gem5.DemandExtractor;
import org.palladiosimulator.hwsimcoupling.consumers.gem5.ErrorDetector;
import org.palladiosimulator.hwsimcoupling.util.CommandHandler;

public class CommandHandlerGem5 implements CommandHandler{

	@Override
	public CopyCommand getCopyCommand(String source_path) {
		return new CopyCommandGem5(source_path);
	}

	@Override
	public ExtractionCommand getExtractionCommand(String methodname) {
		return new ExtractionCommandGem5(methodname);
	}

	@Override
	public SimulationCommand getSimulationCommand(String system, String executable, String methodname, String parameters) {
		return new SimulationCommandGem5(system, executable, methodname, parameters);
	}

	@Override
	public OutputConsumer getOutputConsumer() {
		return new DemandExtractor();
	}

	@Override
	public ErrorConsumer getErrorConsumer() {
		return new ErrorDetector();
	}

	
	
}
