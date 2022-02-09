package org.palladiosimulator.hwsimcoupling.scheduler.resources.active.gem5;

import java.io.Serializable;
import java.util.Map;

import org.palladiosimulator.hwsimcoupling.commands.gem5.docker.CommandHandlerGem5;
import org.palladiosimulator.hwsimcoupling.util.DemandCache.RESOURCE;
import org.palladiosimulator.hwsimcoupling.util.impl.DemandCacheImpl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.IResourceTableManager;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;

public class SimGem5DelayResource extends SimDelayResource {
	
	private static DemandCacheImpl demandCache;
	
	public SimGem5DelayResource(SchedulerModel model, String name, String id,
			IResourceTableManager resourceTableManager) {
		super(model, name, id, resourceTableManager);
		demandCache = DemandCacheImpl.getDemandCacheImpl(new CommandHandlerGem5());
	}
	
	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceID,
            Map<String, Serializable> parameterMap, double demand) {
		
		this.doProcessing(process, resourceServiceID, demandCache.get(parameterMap, RESOURCE.CPU));

    }
}
