package org.senla.ecosystem.work.serialization;

import org.senla.ecosystem.work.animal.service.IAnimalService;
import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;
import org.senla.ecosystem.work.ecosystem.service.IEcosystemService;
import org.senla.ecosystem.work.plant.service.IPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

@Service
public class LoadState {
    private final IPlantService plantService;
    private final IAnimalService animalService;
    private final IEcosystemService ecosystemService;

    @Autowired
    public LoadState(IPlantService plantService, IAnimalService animalService, IEcosystemService ecosystemService) {
        this.plantService = plantService;
        this.animalService = animalService;
        this.ecosystemService = ecosystemService;
    }

    public void load() {
        Scanner scanner = new Scanner(System.in);
        File dir = new File("src/main/resources/saves/");
        System.out.println(Arrays.toString(dir.list()));
        System.out.println("введите имя файла" + '\n');
        String fileName = scanner.nextLine();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("src/main/resources/saves/" + fileName)))) {
            Ecosystem ecosystem = (Ecosystem) objectInputStream.readObject();
            plantService.setPlants(ecosystem.getPlants());
            animalService.setAnimals(ecosystem.getAnimals());
            ecosystemService.setEcosystem(ecosystem);
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException("Load state fail.");
        }
    }
}
