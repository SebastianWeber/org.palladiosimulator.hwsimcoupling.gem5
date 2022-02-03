package org.palladiosimulator.hwsimcoupling.consumers.gem5;

import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;

public class DemandExtractor implements OutputConsumer {

	double demand;
	
	@Override
	public void accept(String t) {
		if (t.contains("Demand:")) {
			demand = Double.parseDouble(t.replace("Demand:", ""));
		}
	}
	
	public double get_demand() {
		return demand;
	}
	
}
