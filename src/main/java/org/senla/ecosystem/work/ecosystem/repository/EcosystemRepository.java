package org.senla.ecosystem.work.ecosystem.repository;

import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;
import org.springframework.stereotype.Repository;

import java.io.File;


@Repository
public class EcosystemRepository implements IEcosystemRepository {
    private Ecosystem ecosystem = new Ecosystem();

    @Override
    public void addEcosystem(Ecosystem ecosystem) {
        this.ecosystem = ecosystem;
    }

    @Override
    public void deleteEcosystem(Integer id) {
        File dir = new File("src/main/resources/saves/" + id + ".txt");
        dir.deleteOnExit();
    }

    @Override
    public Ecosystem getEcosystem() {
        return ecosystem;
    }

    @Override
    public void setEcosystem(Ecosystem ecosystem) {
        this.ecosystem = ecosystem;
    }

    @Override
    public void setTemperature(Integer temperature) {
        this.ecosystem.setTemperature(temperature);
    }

    @Override
    public void setWater(Integer water) {
        this.ecosystem.setWater(water);
    }
}
