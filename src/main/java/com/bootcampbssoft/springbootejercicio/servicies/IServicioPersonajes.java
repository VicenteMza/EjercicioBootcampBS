package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Personaje;

import java.util.List;

public interface IServicioPersonajes {
    public Personaje agregarPersonaje(Personaje personaje);
    public List<Personaje> mostrarTodosLosPersonajes();
    /*
    public List<Personaje> buscarPorNombre(String nombre);
    public List<Personaje> buscarPorEdad(int edad);


    public Personaje actualizarPersonajePorID(int id, Personaje personaje);
    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta);
     */
}
