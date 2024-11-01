package org.senla.ecosystem.work.animal.service;

import org.senla.ecosystem.work.animal.entity.Animal;

import java.util.List;

public interface IAnimalService {
    void addAnimal();
    void deleteAnimal();
    void deleteRandomAnimal();
    Animal getAnimal();

    void setAnimals(List<Animal> animals);

    List<Animal> getAnimals();
}
