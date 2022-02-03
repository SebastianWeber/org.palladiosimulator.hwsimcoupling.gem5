package org.palladiosimulator.hwsimcoupling.scheduler.resources.active.gem5;

import java.io.Serializable;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.gem5.CommandHandlerGem5;
import org.palladiosimulator.hwsimcoupling.util.impl.DemandCacheImpl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;
import de.uka.ipd.sdq.scheduler.resources.active.SimProcessorSharingResource;

public class SimGem5ProcessorSharingResource extends SimProcessorSharingResource {
	
	private DemandCacheImpl demandCache;
	
	public SimGem5ProcessorSharingResource(SchedulerModel model, String name, String id, long capacity,
			IResourceTableManager resourceTableManager) {
		super(model, name, id, capacity, resourceTableManager);
		demandCache = new DemandCacheImpl(new CommandHandlerGem5());
	}
	
	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand) {
		
		this.doProcessing(process, resourceServiceID, demandCache.get(parameterMap));

    }
}
