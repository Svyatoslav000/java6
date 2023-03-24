package com.taco_group.taco.controllers;

import com.taco_group.taco.Ingridients.Type;
import com.taco_group.taco.Ingridients;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

;


@Component
public class IngridientsID implements Converter<String, Ingridients>{

    private Map<String, Ingridients> ingridientMap = new HashMap<>();

    public IngridientsID() {
        ingridientMap.put("1", new Ingridients("1", "Белый хлеб", Type.WRAP));
        ingridientMap.put("2", new Ingridients("2", "Колбаса сырокопченая", Type.PROTEIN));
        ingridientMap.put("3", new Ingridients("3", "Колбаса докторская", Type.PROTEIN));
        ingridientMap.put("4", new Ingridients("4", "Помидоры", Type.VEGGIES));
    }

    @Override
    public Ingridients convert(String id){
        return ingridientMap.get(id);
    }

}
