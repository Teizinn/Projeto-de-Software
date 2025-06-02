package com.example.ledcontroller.controller;

import com.example.ledcontroller.service.LedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LedController {

    @Autowired
    private LedService ledService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ledOn", ledService.isLedOn());
        return "index";
    }

    @PostMapping("/toggle")
    public String toggleLed(Model model) {
        ledService.toggleLed();
        model.addAttribute("ledOn", ledService.isLedOn());
        return "index";
    }
}