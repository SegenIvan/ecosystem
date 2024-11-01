package org.senla.ecosystem.work.ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuController {

    private final Builder builder;
    private final Navigator navigator;

    @Autowired
    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            navigator.setCurrentMenu(builder.getRootMenu());
            navigator.printMenu();
            Integer index = -1;
            while (!index.equals(10)) {
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt();
                    navigator.navigate(index);
                    navigator.printMenu();
                } else run();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("wrong input");
            run();
        }
    }
}
