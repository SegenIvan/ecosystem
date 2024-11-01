package org.senla.ecosystem.work.plant.repository;

import org.senla.ecosystem.work.plant.entity.Plant;
import org.senla.ecosystem.work.plant.exception.PlantRepositoryException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlantRepository implements IPlantRepository {

    private List<Plant> plants = new ArrayList<>();

    @Override
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    @Override
    public void deletePlant(Integer id) {
        plants.removeIf(plant -> plant.getId().equals(id));
        throw new PlantRepositoryException("Delete plant by id failed");
    }

    @Override
    public Plant getPlant(Integer id) {
        for (Plant plant : plants) {
            if (plant.getId().equals(id)) {
                return plant;
            }
        }
        throw new PlantRepositoryException("Get plant by id failed");
    }

    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
