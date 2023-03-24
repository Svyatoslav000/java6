package com.taco_group.taco;

import lombok.Data;

@Data
public class Ingridients {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,

    }
}
