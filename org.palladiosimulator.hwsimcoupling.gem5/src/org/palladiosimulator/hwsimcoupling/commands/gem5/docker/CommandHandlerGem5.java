package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.io.Serializable;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.CopyCommand;
import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;
import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;
import org.palladiosimulator.hwsimcoupling.consumers.ErrorConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;
import org.palladiosimulator.hwsimcoupling.consumers.gem5.DemandExtractor;
import org.palladiosimulator.hwsimcoupling.consumers.gem5.ErrorDetector;
import org.palladiosimulator.hwsimcoupling.util.CommandHandler;

public class CommandHandlerGem5 extends CommandHandler{

	public CommandHandlerGem5() {
		parameters = new String[] {"system", "executable", "methodname", "parameter"};
	}
	
	@Override
	public CopyCommand getCopyCommand(Map<String, Serializable> parameterMap, String source_path) {
		return new CopyCommandGem5(source_path);
	}

	@Override
	public ExtractionCommand getExtractionCommand(Map<String, Serializable> parameterMap) {
		return new ExtractionCommandGem5(parameterMap);
	}

	@Override
	public SimulationCommand getSimulationCommand(Map<String, Serializable> parameterMap) {
		return new SimulationCommandGem5(parameterMap);
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
