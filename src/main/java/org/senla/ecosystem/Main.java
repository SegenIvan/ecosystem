package org.senla.ecosystem;

import org.senla.ecosystem.work.ui.MenuController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        MenuController menuController = applicationContext.getBean(MenuController.class);
        menuController.run();
    }
}