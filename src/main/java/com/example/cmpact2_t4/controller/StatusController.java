package com.example.cmpact2_t4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class StatusController {

    // Endpoint c: Respuesta en formato de objeto simple / JSON
    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return Map.of(
                "status", "UP",
                "alumno", "Cristian Martínez Pacheco",
                "matricula", "23161016",
                "grupo", "7SC"
        );
    }
}