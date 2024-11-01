package org.senla.ecosystem.work.ecosystem.repository;

import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;

public interface IEcosystemRepository {
    void addEcosystem(Ecosystem ecosystem);

    void deleteEcosystem(Integer id);

    Ecosystem getEcosystem();

    void setEcosystem(Ecosystem ecosystem);

    void setTemperature(Integer temperature);

    void setWater(Integer water);
}
