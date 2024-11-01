package org.senla.ecosystem.work.ui.actions.ecosystemActions;

import org.senla.ecosystem.work.ui.actions.AbstractAction;
import org.senla.ecosystem.work.ui.actions.IAction;
import org.springframework.stereotype.Component;

@Component
public class SetWater extends AbstractAction implements IAction {
    @Override
    public void execute() {
        ecosystemService.setWater();
    }
}
