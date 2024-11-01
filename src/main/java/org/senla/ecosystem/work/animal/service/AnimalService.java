package org.senla.ecosystem.work.animal.service;

import org.senla.ecosystem.work.animal.entity.Animal;
import org.senla.ecosystem.work.animal.entity.AnimalKind;
import org.senla.ecosystem.work.animal.repository.IAnimalRepository;
import org.senla.ecosystem.work.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimalService implements IAnimalService {

    private final IAnimalRepository animalRepository;

    private final GenerateId generateId;

    @Autowired
    public AnimalService(IAnimalRepository animalRepository, GenerateId generateId) {
        this.animalRepository = animalRepository;
        this.generateId = generateId;
    }


    @Override
    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите тип животного" + '\n');
        System.out.println("1.Кот" + "\n" + "2.Собака" + "\n" + "3.Корова" + "\n" + "4.Жираф"
                + "\n" + "5.Лев" + "\n" + "6.Мышь" + "\n" + "7.Крокодил");
        AnimalKind animalKind;
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                animalKind = AnimalKind.CAT;
                break;
            case 2:
                animalKind = AnimalKind.DOG;
                break;
            case 3:
                animalKind = AnimalKind.COW;
                break;
            case 4:
                animalKind = AnimalKind.GIRAFFE;
                break;
            case 5:
                animalKind = AnimalKind.LION;
                break;
            case 6:
                animalKind = AnimalKind.MOUSE;
                break;
            case 7:
                animalKind = AnimalKind.CROCODILE;
                break;
            default:
                System.out.println("неверный выбор)");
                return;
        }
        scanner.nextLine();
        System.out.println("введите имя");
        String animalName = scanner.nextLine();
        System.out.println("введите цвет");
        String animalColor = scanner.nextLine();
        System.out.println("введите возраст");
        Integer animalAge = scanner.nextInt();

        animalRepository.addAnimal(new Animal(generateId.generateIdAnimal(animalRepository.getAnimals()),
                animalName, animalColor, animalAge, animalKind));
    }

    @Override
    public void deleteAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id");
        Integer animalId = scanner.nextInt();
        animalRepository.deleteAnimal(animalId);
    }

    public void deleteRandomAnimal() {
        int animalCount = animalRepository.getAnimals().size();
        int animalId;
        int index;
        if (animalCount != 0) {
            if (animalCount == 1) {
                animalId = animalRepository.getAnimals().get(0).getId();
            } else {
                index = ThreadLocalRandom.current().nextInt(1, animalCount + 1);
                animalId = animalRepository.getAnimals().get(index).getId();
            }
        } else {
            return;
        }
        animalRepository.deleteAnimal(animalId);
    }

    @Override
    public Animal getAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id");
        Integer animalId = scanner.nextInt();
        return animalRepository.getAnimal(animalId);
    }

    @Override
    public void setAnimals(List<Animal> animals) {
        animalRepository.setAnimals(animals);
    }

    @Override
    public List<Animal> getAnimals() {
        return animalRepository.getAnimals();
    }
}
