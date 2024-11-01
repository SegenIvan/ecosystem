package org.senla.ecosystem.work.plant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Plant implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private PlantKind kind;
    private String name;
    private String color;
    private Integer age;
}
