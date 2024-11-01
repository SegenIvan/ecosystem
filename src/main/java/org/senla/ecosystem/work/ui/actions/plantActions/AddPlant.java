package org.senla.ecosystem.work.ui.actions.plantActions;


import org.senla.ecosystem.work.ui.actions.AbstractAction;
import org.senla.ecosystem.work.ui.actions.IAction;
import org.springframework.stereotype.Component;

@Component
public class AddPlant extends AbstractAction implements IAction {

    @Override
    public void execute() {
        plantService.addPlant();
    }
}
