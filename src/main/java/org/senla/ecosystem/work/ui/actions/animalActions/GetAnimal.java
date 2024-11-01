package org.senla.ecosystem.work.ui.actions.animalActions;

import org.senla.ecosystem.work.ui.actions.AbstractAction;
import org.senla.ecosystem.work.ui.actions.IAction;
import org.springframework.stereotype.Component;

@Component
public class GetAnimal extends AbstractAction implements IAction {
    @Override
    public void execute() {
        System.out.println(animalService.getAnimal());
    }
}
