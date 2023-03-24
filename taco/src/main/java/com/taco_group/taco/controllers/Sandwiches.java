package com.taco_group.taco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.taco_group.taco.Sandwich1;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("sandwich1")
public class Sandwiches {
    @GetMapping("/current")
    public String orderForm(){
        return "home";
    }

    @PostMapping
    public String processOrder(
            @Valid Sandwich1 order, Errors errors, SessionStatus sessionStatus
    ){
        if (errors.hasErrors()){
            return "home";
        }

        log.info("Order submitted {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}