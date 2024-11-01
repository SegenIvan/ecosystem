package org.senla.ecosystem.work.ecosystem.service;

import org.senla.ecosystem.work.ecosystem.entity.Ecosystem;

public interface IEcosystemService {
    void addEcosystem();

    void deleteEcosystem();

    void updateEcosystem();

    void setTemperature();

    void setWater();

    Ecosystem getEcosystem();

    void setEcosystem(Ecosystem ecosystem);
}
