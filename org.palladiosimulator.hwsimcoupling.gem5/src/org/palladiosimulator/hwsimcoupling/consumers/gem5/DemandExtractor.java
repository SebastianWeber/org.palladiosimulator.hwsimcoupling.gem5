package org.palladiosimulator.hwsimcoupling.consumers.gem5;

import org.palladiosimulator.hwsimcoupling.consumers.OutputConsumer;

public class DemandExtractor implements OutputConsumer {

	private final String keyword = "Demand:";
	
	private double demand;
	
	@Override
	public void accept(String t) {
		if (t.contains(keyword)) {
			demand = Double.parseDouble(t.replace(keyword, ""));
		}
	}
	
	public double get_demand() {
		return demand;
	}
	
}
