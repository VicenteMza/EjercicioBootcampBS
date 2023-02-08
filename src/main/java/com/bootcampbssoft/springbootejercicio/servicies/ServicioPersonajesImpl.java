package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ServicioPersonajesImpl{// implements IServicioPersonajes{
    /*
    @Autowired
    IRepositorioPersonajes iRpersonajes;
    @Override
    public List<Personaje> buscarPorNombre(String nombre) {
        return iRpersonajes.buscarPorNombre(nombre);
    }

    @Override
    public List<Personaje> buscarPorEdad(int edad) {
        return iRpersonajes.buscarPorEdad(edad);
    }
    @Override
    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta) {
        return iRpersonajes.mostrarPersonajePorRangoDeEdad(desde,hasta);
    }
    @Override
    public Personaje agregarPersonaje(Personaje personaje) {

        return iRpersonajes.agregarPersonaje(personaje);
    }

    @Override
    public List<Personaje> mostrarTodosLosPersonajes() {
        return iRpersonajes.mostrarTodosLosPersonajes();
    }
    @Override
    public Personaje actualizarPersonajePorID(int id, Personaje personaje) {
        if (!this.iRpersonajes.existeId(id)){
            return null;
        }
        return iRpersonajes.actualizarPersonajePorID(id,personaje);
    }
     */
}
