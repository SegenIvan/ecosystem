package org.senla.ecosystem.work.plant.repository;

import org.senla.ecosystem.work.plant.entity.Plant;

import java.util.List;

public interface IPlantRepository {
    void addPlant(Plant plant);

    void deletePlant(Integer id);

    Plant getPlant(Integer id);

    List<Plant> getPlants();

    void setPlants(List<Plant> plants);
}
