package org.senla.ecosystem.work.util;

import org.senla.ecosystem.work.animal.entity.Animal;
import org.senla.ecosystem.work.plant.entity.Plant;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@Service
public class GenerateId {

    public Integer generateIdAnimal(List<Animal> animals) {

        if (animals.isEmpty()) {
            return 1;
        }
        Animal animal = Collections.max(animals, Comparator.comparingInt(Animal::getId));
        return animal.getId() + 1;
    }

    public Integer generateIdPlant(List<Plant> plants) {

        if (plants.isEmpty()) {
            return 1;
        }
        Plant plant = Collections.max(plants, Comparator.comparingInt(Plant::getId));
        return plant.getId() + 1;
    }

    public Integer generateIdEcosystem() {
        File dir = new File("src/main/resources/saves/");
        int id;
        if (dir.length() == 0) {
            id = 1;
        } else {
            id = Objects.requireNonNull(dir.list()).length + 1;
        }
        while (new File("src/main/resources/saves/" + id + ".txt").exists()) {
            id++;
        }
        return id;
    }
}
