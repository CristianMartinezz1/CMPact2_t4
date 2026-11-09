package com.example.cmpact2_t4.dto;

// DTO: solo los datos que viajan entre el controlador, la vista y las peticiones
public class MateriaDTO {

    private Integer id;
    private String nombre;
    private String categoria;
    private String profesor;
    private Integer creditos;

    public MateriaDTO() {
    }

    public MateriaDTO(Integer id, String nombre, String categoria, String profesor, Integer creditos) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.profesor = profesor;
        this.creditos = creditos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
