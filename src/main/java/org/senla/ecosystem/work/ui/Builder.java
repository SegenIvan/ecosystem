package org.senla.ecosystem.work.ui;


import org.senla.ecosystem.work.serialization.LoadState;
import org.senla.ecosystem.work.serialization.SaveState;
import org.senla.ecosystem.work.ui.actions.animalActions.AddAnimal;
import org.senla.ecosystem.work.ui.actions.animalActions.DeleteAnimal;
import org.senla.ecosystem.work.ui.actions.animalActions.GetAllAnimal;
import org.senla.ecosystem.work.ui.actions.animalActions.GetAnimal;
import org.senla.ecosystem.work.ui.actions.ecosystemActions.*;
import org.senla.ecosystem.work.ui.actions.plantActions.AddPlant;
import org.senla.ecosystem.work.ui.actions.plantActions.DeletePlant;
import org.senla.ecosystem.work.ui.actions.plantActions.GetAllPlant;
import org.senla.ecosystem.work.ui.actions.plantActions.GetPlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Builder {
    private final SaveState saveState;
    private final LoadState loadState;
    private final Menu rootMenu;
    private final AddAnimal addAnimal;
    private final AddEcosystem addEcosystem;
    private final DeleteEcosystem deleteEcosystem;
    private final GetStatus getStatus;
    private final SetTemperature setTemperature;
    private final SetWater setWater;
    private final GetAnimal getAnimal;
    private final DeleteAnimal deleteAnimal;
    private final GetAllAnimal getAllAnimal;
    private final AddPlant addPlant;
    private final GetPlant getPlant;
    private final DeletePlant deletePlant;
    private final GetAllPlant getAllPlant;

    @Autowired
    public Builder(AddEcosystem addEcosystem, SaveState saveState, LoadState loadState, Menu rootMenu, AddAnimal addAnimal, DeleteEcosystem deleteEcosystem,
                   GetStatus getStatus, SetTemperature setTemperature, SetWater setWater, GetAnimal getAnimal, DeleteAnimal deleteAnimal, GetAllAnimal getAllAnimal,
                   AddPlant addPlant, GetPlant getPlant, DeletePlant deletePlant, GetAllPlant getAllPlant) {
        this.addEcosystem = addEcosystem;
        this.saveState = saveState;
        this.loadState = loadState;
        this.rootMenu = rootMenu;
        this.addAnimal = addAnimal;
        this.deleteEcosystem = deleteEcosystem;
        this.getStatus = getStatus;
        this.setTemperature = setTemperature;
        this.setWater = setWater;
        this.getAnimal = getAnimal;
        this.deleteAnimal = deleteAnimal;
        this.getAllAnimal = getAllAnimal;
        this.addPlant = addPlant;
        this.getPlant = getPlant;
        this.deletePlant = deletePlant;
        this.getAllPlant = getAllPlant;
        this.buildMenu();
    }


    public void buildMenu() {
        rootMenu.addMenuItem(new MenuItem("0. Меню экосистемы", () -> {
        }, createEcosystemMenu()));

        rootMenu.addMenuItem(new MenuItem("1. Меню животных", () -> {
        }, createAnimalMenu()));

        rootMenu.addMenuItem(new MenuItem("2. Меню растений", () -> {
        }, createPlantMenu()));

        rootMenu.addMenuItem(new MenuItem("3. Сохранить", saveState::save, rootMenu));

        rootMenu.addMenuItem(new MenuItem("4. Загрузить", loadState::load, rootMenu));

        rootMenu.addMenuItem(new MenuItem("5. Выход из программы", saveState::save, null));
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Menu createEcosystemMenu() {
        Menu ecosystemMenu = new Menu();
        ecosystemMenu.addMenuItem(new MenuItem("0. Создать экосистему", addEcosystem, ecosystemMenu));
        ecosystemMenu.addMenuItem(new MenuItem("1. Задать температуру", setTemperature, ecosystemMenu));
        ecosystemMenu.addMenuItem(new MenuItem("2. Задать количество воды", setWater, ecosystemMenu));
        ecosystemMenu.addMenuItem(new MenuItem("3. Получить статус", getStatus, ecosystemMenu));
        ecosystemMenu.addMenuItem(new MenuItem("4. Удалить экосистему", deleteEcosystem, ecosystemMenu));
        ecosystemMenu.addMenuItem(new MenuItem("5. Выход в предыдущее меню", () -> System.out.println("----"), rootMenu));

        return ecosystemMenu;
    }

    public Menu createAnimalMenu() {
        Menu animalMenu = new Menu();
        animalMenu.addMenuItem(new MenuItem("0. Добавить животное", addAnimal, animalMenu));
        animalMenu.addMenuItem(new MenuItem("1. Удалить животное", deleteAnimal, animalMenu));
        animalMenu.addMenuItem(new MenuItem("2. Получить животное", getAnimal, animalMenu));
        animalMenu.addMenuItem(new MenuItem("3. Получить всех животных", getAllAnimal, animalMenu));
        animalMenu.addMenuItem(new MenuItem("4. Выход в предыдущее меню", () -> System.out.println("----"), rootMenu));

        return animalMenu;
    }

    public Menu createPlantMenu() {
        Menu plantMenu = new Menu();
        plantMenu.addMenuItem(new MenuItem("0. Добавить растение", addPlant, plantMenu));
        plantMenu.addMenuItem(new MenuItem("1. Удалить растение", deletePlant, plantMenu));
        plantMenu.addMenuItem(new MenuItem("2. Получить растение", getPlant, plantMenu));
        plantMenu.addMenuItem(new MenuItem("3. Получить все растения", getAllPlant, plantMenu));
        plantMenu.addMenuItem(new MenuItem("4. Выход в предыдущее меню", () -> System.out.println("----"), rootMenu));

        return plantMenu;
    }
}
