package org.palladiosimulator.hwsimcoupling.scheduler.gem5;

import org.palladiosimulator.hwsimcoupling.scheduler.resources.active.gem5.SimGem5ProcessorSharingResource;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;

public class Gem5SchedulerExtensionFactory implements SchedulerExtensionFactory {

	public Gem5SchedulerExtensionFactory() {
		
	}
	
	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores, IResourceTableManager resourceTableManager) {

		return new SimGem5ProcessorSharingResource(model, resourceId, resourceId, numberOfCores, resourceTableManager);
	}

}
