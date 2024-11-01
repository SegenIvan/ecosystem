package org.senla.ecosystem.work.ui.actions.animalActions;

import org.senla.ecosystem.work.ui.actions.AbstractAction;
import org.senla.ecosystem.work.ui.actions.IAction;
import org.springframework.stereotype.Component;

@Component
public class AddAnimal extends AbstractAction implements IAction {

    @Override
    public void execute() {
        animalService.addAnimal();
    }
}
