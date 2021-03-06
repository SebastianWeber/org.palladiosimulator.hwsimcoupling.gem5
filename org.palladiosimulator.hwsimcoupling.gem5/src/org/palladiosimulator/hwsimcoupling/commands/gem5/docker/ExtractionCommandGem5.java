package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.ExtractionCommand;
import org.palladiosimulator.hwsimcoupling.util.MapHelper;

public class ExtractionCommandGem5 extends CommandGem5 implements ExtractionCommand {

    private String methodname;

    public ExtractionCommandGem5(Map<String, Serializable> parameterMap) {
        this.methodname = MapHelper.getRequiredValueFromMap(parameterMap, "methodname");
    }

    @Override
    public List<String> getCommand() {
        List<String> command = getShell();
        command.add("docker");
        command.add("exec");
        command.add("gem5");
        command.add("python");
        command.add(destination_path + "extract.py");
        command.add(methodname);
        return command;
    }

}