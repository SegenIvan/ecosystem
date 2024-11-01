package org.senla.ecosystem.work.animal.repository;

import org.senla.ecosystem.work.animal.entity.Animal;

import java.util.List;

public interface IAnimalRepository {
    void addAnimal(Animal animal);

    void deleteAnimal(Integer id);


    Animal getAnimal(Integer id);

    List<Animal> getAnimals();

    void setAnimals(List<Animal> animals);
}
