package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Personaje;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioPersonajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPersonajesImpl implements IServicioPersonajes{
    @Autowired
    IRepositorioPersonajes iRepositorioPersonajes;

    @Override
    public Personaje agregarPersonaje(Personaje personaje) {
        personaje.setNombre(personaje.getNombre().toUpperCase().trim());

        return this.iRepositorioPersonajes.save(personaje);
    }

    @Override
    public List<Personaje> findAll() {
        return this.iRepositorioPersonajes.findAll();
    }
    /*

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
    public Personaje actualizarPersonajePorID(int id, Personaje personaje) {
        if (!this.iRpersonajes.existeId(id)){
            return null;
        }
        return iRpersonajes.actualizarPersonajePorID(id,personaje);
    }
     */
}
