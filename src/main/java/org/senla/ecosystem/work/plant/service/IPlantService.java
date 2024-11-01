package org.senla.ecosystem.work.plant.service;

import org.senla.ecosystem.work.plant.entity.Plant;

import java.util.List;

public interface IPlantService {
    void addPlant();

    void deletePlant();

    Plant getPlant();

    List<Plant> getPlants();

    void setPlants(List<Plant> plants);
}
