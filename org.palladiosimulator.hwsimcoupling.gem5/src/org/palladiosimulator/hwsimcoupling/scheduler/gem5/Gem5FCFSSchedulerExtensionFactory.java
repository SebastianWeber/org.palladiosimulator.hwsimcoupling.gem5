package org.palladiosimulator.hwsimcoupling.scheduler.gem5;

import org.palladiosimulator.hwsimcoupling.scheduler.resources.active.gem5.SimGem5FCFSResource;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;

public class Gem5FCFSSchedulerExtensionFactory implements SchedulerExtensionFactory {

	public Gem5FCFSSchedulerExtensionFactory() {
		
	}
	
	@Override
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId,
			long numberOfCores, IResourceTableManager resourceTableManager) {

		return new SimGem5FCFSResource(model, resourceId, resourceId, numberOfCores, resourceTableManager);
	}

}
