package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.dominio.Personaje;

import java.util.List;

public interface IRepositorioPersonajes {
    public List<Personaje> buscarPorNombre(String nombre);
    public List<Personaje> buscarPorEdad(int edad);
    public List<Personaje> mostrarTodosLosPersonajes();
    public Personaje agregarPersonaje(Personaje personaje);
    public Personaje actualizarPersonajePorID(int id, Personaje personaje);
    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta);
    public boolean existeId(int id);
}
