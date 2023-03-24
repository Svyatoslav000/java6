package com.taco_group.taco;

import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
public class Sandwich {
    @NotNull
    @Size(min=5)
    private String name;

    @NotNull
    @Size(min=1)
    private List<Ingridients> ingridients;
}