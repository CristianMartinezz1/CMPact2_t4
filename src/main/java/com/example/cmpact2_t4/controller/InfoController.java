package com.example.cmpact2_t4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InfoController {

    // Endpoint a: Identificación del proyecto / alumno
    @GetMapping("/proyecto")
    public String getProyectoInfo() {
        return "Proyecto Spring Boot - Ingeniería en Sistemas Computacionales (Cristian Martínez Pacheco - CMP)";
    }

    // Endpoint b: Lista simulada (materias)
    @GetMapping("/materias")
    public List<String> getMaterias() {
        return List.of(
                "Sistemas Distribuidos",
                "Programación Web",
                "Ingeniería de Software",
                "Administración de Bases de Datos"
        );
    }
}