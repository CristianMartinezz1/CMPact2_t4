package com.example.cmpact2_t4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.cmpact2_t4.dto.MateriaDTO;

// Datos simulados en memoria (todavía no hay base de datos)
@Service
public class MateriaService {

    private final List<MateriaDTO> materias = new ArrayList<>();
    private final AtomicInteger siguienteId = new AtomicInteger(1);

    public MateriaService() {
        agregar(new MateriaDTO(0, "Sistemas Distribuidos", "Sistemas", "Profesor A", 5));
        agregar(new MateriaDTO(0, "Programación Web", "Programación", "Profesor B", 5));
        agregar(new MateriaDTO(0, "Ingeniería de Software", "Sistemas", "Profesor C", 4));
        agregar(new MateriaDTO(0, "Administración de Bases de Datos", "Bases de Datos", "Profesor D", 5));
    }

    public synchronized List<MateriaDTO> listar() {
        return List.copyOf(materias);
    }

    public synchronized List<MateriaDTO> listarPorCategoria(String categoria) {
        return materias.stream()
                .filter(m -> m.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    public synchronized Optional<MateriaDTO> buscarPorId(int id) {
        return materias.stream().filter(m -> m.getId() != null && m.getId() == id).findFirst();
    }

    public synchronized List<String> categorias() {
        return materias.stream().map(MateriaDTO::getCategoria).distinct().sorted().toList();
    }

    public synchronized MateriaDTO agregar(MateriaDTO materia) {
        materia.setId(siguienteId.getAndIncrement());
        materias.add(materia);
        return materia;
    }
}
