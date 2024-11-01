package org.senla.ecosystem.work.animal.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String color;
    private Integer age;
    private AnimalKind kind;
}
