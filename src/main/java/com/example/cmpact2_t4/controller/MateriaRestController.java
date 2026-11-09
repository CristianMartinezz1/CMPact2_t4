package com.example.cmpact2_t4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cmpact2_t4.dto.MateriaDTO;
import com.example.cmpact2_t4.service.MateriaService;

// Controlador REST: recibe y regresa JSON usando el mismo DTO que las vistas
@RestController
@RequestMapping("/api/dto/materias")
public class MateriaRestController {

    private final MateriaService materiaService;

    public MateriaRestController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public List<MateriaDTO> listar() {
        return materiaService.listar();
    }

    // POST probado con Postman: el cuerpo JSON se convierte a MateriaDTO con @RequestBody
    @PostMapping
    public ResponseEntity<MateriaDTO> crear(@RequestBody MateriaDTO materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.agregar(materia));
    }
}
