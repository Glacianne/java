package com.example.demo_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsCotnroller {

    @GetMapping("/mycards")
    public String getAccountDetails(){
        return "Chui la carte";
    }
}
