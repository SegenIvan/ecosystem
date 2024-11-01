package org.senla.ecosystem.work.ecosystem.service;

import org.senla.ecosystem.work.animal.service.IAnimalService;
import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;
import org.senla.ecosystem.work.ecosystem.repository.IEcosystemRepository;
import org.senla.ecosystem.work.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@Service
public class EcosystemService implements IEcosystemService {

    private final IEcosystemRepository ecosystemRepository;
    private final IAnimalService animalService;
    private final GenerateId generateId;

    @Autowired
    public EcosystemService(IEcosystemRepository ecosystemRepository, IAnimalService animalService, GenerateId generateId) {
        this.ecosystemRepository = ecosystemRepository;
        this.animalService = animalService;
        this.generateId = generateId;
    }

    @Override
    public void addEcosystem() {
        Scanner scanner = new Scanner(System.in);
        Ecosystem ecosystem = new Ecosystem();

        ecosystem.setId(generateId.generateIdEcosystem());
        System.out.println("введите кол-во воды");
        Integer water = scanner.nextInt();
        System.out.println("введите температуру");
        Integer temperature = scanner.nextInt();
        ecosystem.setWater(water);
        ecosystem.setTemperature(temperature);
        ecosystem.setDateCreating(LocalDateTime.now());
        ecosystemRepository.addEcosystem(ecosystem);
    }

    @Override
    public void deleteEcosystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id");
        ecosystemRepository.deleteEcosystem(scanner.nextInt());
    }

    @Override
    public void updateEcosystem() {
        Ecosystem ecosystem = ecosystemRepository.getEcosystem();
        long daysFromBeginning =  ChronoUnit.HOURS.between(ecosystem.getDateCreating(), LocalDateTime.now());
        ecosystem.setDaysFromBeginning(ecosystem.getDateCreating().plusDays(daysFromBeginning).getDayOfMonth());
        if ((ecosystem.getDaysFromBeginning() & 1) == 0) {
            ecosystem.setWater(ecosystem.getWater() - 2);
            ecosystem.setTemperature(ecosystem.getTemperature() - 1);
        }
        if (ecosystem.getWater() < 5) {
            System.out.println("Дайте попить...");
        }
        if (ecosystem.getTemperature() < 5) {
            System.out.println("Холодно...");
        }
        if (ecosystem.getWater() <= 0){
            System.out.println("Кто-то умер...");
            animalService.deleteRandomAnimal();
        }
    }

    @Override
    public void setTemperature() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите температуру");
        ecosystemRepository.setTemperature(scanner.nextInt());
    }

    @Override
    public void setWater() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите кол-во воды");
        ecosystemRepository.setWater(scanner.nextInt());
    }

    @Override
    public Ecosystem getEcosystem() {
        updateEcosystem();
        return ecosystemRepository.getEcosystem();
    }

    @Override
    public void setEcosystem(Ecosystem ecosystem) {
        ecosystemRepository.setEcosystem(ecosystem);
    }
}
