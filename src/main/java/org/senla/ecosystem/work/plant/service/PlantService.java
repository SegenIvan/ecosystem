package org.senla.ecosystem.work.plant.service;

import org.senla.ecosystem.work.plant.entity.Plant;
import org.senla.ecosystem.work.plant.entity.PlantKind;
import org.senla.ecosystem.work.plant.repository.IPlantRepository;
import org.senla.ecosystem.work.util.GenerateId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PlantService implements IPlantService {

    private final IPlantRepository plantRepository;

    private final GenerateId generateIDPlant;

    @Autowired
    public PlantService(IPlantRepository plantRepository, GenerateId generateIDPlant) {
        this.plantRepository = plantRepository;
        this.generateIDPlant = generateIDPlant;
    }

    @Override
    public void addPlant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите тип растения" + '\n');
        System.out.println("1.Дерево" + "\n" + "2.Цветок" + "\n" + "3.Овощ");
        PlantKind plantKind;
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                plantKind = PlantKind.TREE;
                break;
            case 2:
                plantKind = PlantKind.FLOWER;
                break;
            case 3:
                plantKind = PlantKind.VEGETABLE;
                break;
            default:
                System.out.println("неверный выбор)");
                return;
        }
        scanner.nextLine();
        System.out.println("введите название");
        String plantName = scanner.nextLine();
        System.out.println("введите цвет");
        String plantColor = scanner.nextLine();
        System.out.println("введите возраст");
        Integer plantAge = scanner.nextInt();
        plantRepository.addPlant(new Plant(generateIDPlant.generateIdPlant(plantRepository.getPlants()),
                plantKind, plantName, plantColor, plantAge));
    }

    @Override
    public void deletePlant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id");
        Integer plantId = scanner.nextInt();
        plantRepository.deletePlant(plantId);
    }

    @Override
    public Plant getPlant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id");
        Integer plantId = scanner.nextInt();
        return plantRepository.getPlant(plantId);
    }

    public List<Plant> getPlants() {
        return plantRepository.getPlants();
    }

    @Override
    public void setPlants(List<Plant> plants) {
        plantRepository.setPlants(plants);
    }
}
