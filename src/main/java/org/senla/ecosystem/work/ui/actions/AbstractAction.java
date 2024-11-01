package org.senla.ecosystem.work.ui.actions;

import org.senla.ecosystem.work.animal.service.IAnimalService;
import org.senla.ecosystem.work.ecosystem.service.IEcosystemService;
import org.senla.ecosystem.work.plant.service.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractAction {
    @Autowired
    protected IPlantService plantService;
    @Autowired
    protected IAnimalService animalService;

    @Autowired
    protected IEcosystemService ecosystemService;
}
