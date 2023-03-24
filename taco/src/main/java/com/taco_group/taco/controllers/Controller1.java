package com.taco_group.taco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }
    @GetMapping("/Профиль")
    public String prof(Model model) {
        return "profile";
    }
}