package org.senla.ecosystem.work.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Navigator {
    private Menu currentMenu;

    @Autowired
    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void printMenu() {
        currentMenu.getMenuItems().forEach(System.out::println);
    }

    public void navigate(int index) {
        if (currentMenu != null) {
            MenuItem menuItem = currentMenu.getMenuItems().get(index);
            menuItem.doAction();
            currentMenu = menuItem.getNextMenu();
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
