package org.palladiosimulator.hwsimcoupling.commands.gem5.docker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.SimulationCommand;
import org.palladiosimulator.hwsimcoupling.util.MapHelper;

public class SimulationCommandGem5 extends CommandGem5 implements SimulationCommand {

    private String executable;
    private String system;
    private String methodname;
    private String parameters;

    public SimulationCommandGem5(Map<String, Serializable> parameterMap) {
        this.executable = MapHelper.getRequiredValueFromMap(parameterMap, "executable");
        this.system = MapHelper.getRequiredValueFromMap(parameterMap, "system");
        this.methodname = MapHelper.getRequiredValueFromMap(parameterMap, "methodname");
        this.parameters = MapHelper.getRequiredValueFromMap(parameterMap, "parameter");
    }

    @Override
    public List<String> getCommand() {
        List<String> command = getShell();
        command.add("docker");
        command.add("exec");
        command.add("gem5");
        command.add("build/X86/gem5.opt");
        command.add(destination_path + system);
        command.add(executable);
        if (!methodname.equals("main")) {
            command.add(methodname);
        }
        for (String parameter : parameters.split(" ")) {
            command.add(parameter);
        }
        return command;
    }

}
