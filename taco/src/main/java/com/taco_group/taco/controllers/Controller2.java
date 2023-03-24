package com.taco_group.taco.controllers;

import com.taco_group.taco.Ingridients;
import com.taco_group.taco.Ingridients.Type;
import com.taco_group.taco.Sandwich;
import com.taco_group.taco.Sandwich1;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Controller
@SessionAttributes("sandwich1")
@RequestMapping("/Zakaz")
public class Controller2 {
    @ModelAttribute
    public void addIngridientsToModel(Model model){
        List<Ingridients> ingridients = Arrays.asList(
                new Ingridients("1", "Белый хлеб", Type.WRAP),
                new Ingridients("2", "Колбаса сырокопченая", Type.PROTEIN),
                new Ingridients("3", "Колбаса докторская", Type.PROTEIN),
                new Ingridients("4", "Помидоры", Type.VEGGIES)

        );
        Type[] types = Ingridients.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingridients, type));
        }
    }
    @ModelAttribute(name="sandwich1")
    public Sandwich1 sandwich1(){
        return new Sandwich1();
    }

    @ModelAttribute(name="sandwich")
    public Sandwich sandwich(){
        return new Sandwich();
    }

    private Iterable<Ingridients> filterByType(
            List<Ingridients> ingridients, Type type
    ){
        return ingridients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
    @PostMapping
    public String processSandwich(
            @Valid Sandwich sandwich, Errors errors, @ModelAttribute Sandwich1 sandwich1){
        if (errors.hasErrors()){
            return "Zakaz";}
        sandwich1.addSandwich(sandwich);
        log.info("Processing sandwich: {}", sandwich);
        return "/Zakaz";
    }

    @GetMapping("/Zakaz")
    public String zakaz() {
        return "Zakaz";
    }
}
