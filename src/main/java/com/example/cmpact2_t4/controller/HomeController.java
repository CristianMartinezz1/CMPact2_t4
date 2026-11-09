package com.example.cmpact2_t4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // La raíz del proyecto lleva directo a la lista de materias
    @GetMapping("/")
    public String inicio() {
        return "redirect:/materias";
    }
}
