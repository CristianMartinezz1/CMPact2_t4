package com.example.cmpact2_t4.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cmpact2_t4.dto.MateriaDTO;
import com.example.cmpact2_t4.service.MateriaService;

// Controlador MVC: regresa vistas Thymeleaf (HTML), no JSON
@Controller
@RequestMapping("/materias")
public class MateriaViewController {

    private final MateriaService materiaService;

    // @Value: lee propiedades personalizadas de application.properties
    @Value("${app.nombre-proyecto}")
    private String nombreProyecto;

    @Value("${app.autor}")
    private String autor;

    public MateriaViewController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // Se agrega al Model de todas las vistas de este controlador
    @ModelAttribute
    public void datosComunes(Model model) {
        model.addAttribute("nombreProyecto", nombreProyecto);
        model.addAttribute("autor", autor);
    }

    // a) Lista con th:each + @RequestParam opcional para filtrar por categoría
    //    /materias            -> todas
    //    /materias?categoria=Sistemas -> filtradas
    @GetMapping
    public String listar(@RequestParam(required = false) String categoria, Model model) {
        if (categoria == null || categoria.isBlank()) {
            model.addAttribute("materias", materiaService.listar());
        } else {
            model.addAttribute("materias", materiaService.listarPorCategoria(categoria));
        }
        model.addAttribute("categorias", materiaService.categorias());
        model.addAttribute("categoriaSeleccionada", categoria);
        return "materias/lista";
    }

    // @PathVariable: detalle de una materia por su id -> /materias/2
    @GetMapping("/{id}")
    public String detalle(@PathVariable int id, Model model) {
        model.addAttribute("materia", materiaService.buscarPorId(id).orElse(null));
        model.addAttribute("idBuscado", id);
        return "materias/detalle";
    }

    // b) Formulario vacío
    @GetMapping("/nueva")
    public String formulario(Model model) {
        model.addAttribute("materia", new MateriaDTO());
        model.addAttribute("categorias", materiaService.categorias());
        return "materias/formulario";
    }

    // b) @ModelAttribute: Spring llena el DTO con los campos del formulario
    @PostMapping("/nueva")
    public String guardar(@ModelAttribute("materia") MateriaDTO materia, Model model) {
        model.addAttribute("materia", materiaService.agregar(materia));
        return "materias/resultado";
    }
}
