package org.senla.ecosystem.work.animal.repository;


import org.senla.ecosystem.work.animal.entity.Animal;
import org.senla.ecosystem.work.animal.exception.AnimalRepositoryException;
import org.senla.ecosystem.work.ecosystem.repository.IEcosystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalRepository implements IAnimalRepository {
    private final IEcosystemRepository ecosystemRepository;
    private List<Animal> animals = new ArrayList<>();

    @Autowired
    public AnimalRepository(IEcosystemRepository ecosystemRepository) {
        this.ecosystemRepository = ecosystemRepository;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
        ecosystemRepository.getEcosystem().setAnimals(animals);

    }

    @Override
    public void deleteAnimal(Integer id) {
        if (!animals.removeIf(animal -> animal.getId().equals(id))) {
            throw new AnimalRepositoryException("Delete animal by id failed");
        }
    }

    @Override
    public Animal getAnimal(Integer id) {
        for (Animal animal : animals) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        throw new AnimalRepositoryException("Get animal by id failed");
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
