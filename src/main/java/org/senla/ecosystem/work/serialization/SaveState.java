package org.senla.ecosystem.work.serialization;

import org.senla.ecosystem.work.animal.repository.IAnimalRepository;
import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;
import org.senla.ecosystem.work.ecosystem.repository.IEcosystemRepository;
import org.senla.ecosystem.work.plant.repository.IPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class SaveState {
    private final IEcosystemRepository ecosystemRepository;
    private final IPlantRepository plantRepository;
    private final IAnimalRepository animalRepository;

    @Autowired
    public SaveState(IEcosystemRepository ecosystemRepository, IPlantRepository plantRepository, IAnimalRepository animalRepository) {
        this.ecosystemRepository = ecosystemRepository;
        this.plantRepository = plantRepository;
        this.animalRepository = animalRepository;
    }

    public void save() {
        Ecosystem ecosystem = ecosystemRepository.getEcosystem();
        if (ecosystem.getId() == null){
            System.out.println("нечего сохранять");
            return;
        }
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("src/main/resources/saves/"
                + ecosystem.getId() + ".txt")))) {

            ecosystem.setAnimals(animalRepository.getAnimals());
            ecosystem.setPlants(plantRepository.getPlants());
            outputStream.writeObject(ecosystem);
        } catch (IOException | NullPointerException e) {
            throw new SerializationException("Save state fail.");
        }
    }
}
