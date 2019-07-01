package com.excellenthealthSolution.pharmacy.general.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
    @GetMapping(value = {"/home","/mainWindow"})
    public String mainWindow(){
        return "mainWindow";
    }
}
