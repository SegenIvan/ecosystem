package org.senla.ecosystem.work.ecosystem.entity;


import lombok.*;
import org.senla.ecosystem.work.animal.entity.Animal;
import org.senla.ecosystem.work.plant.entity.Plant;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ecosystem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer water;

    private Integer temperature;

    private LocalDateTime dateCreating;

    private Integer daysFromBeginning;

    private List<Plant> plants;

    private List<Animal> animals;
}
