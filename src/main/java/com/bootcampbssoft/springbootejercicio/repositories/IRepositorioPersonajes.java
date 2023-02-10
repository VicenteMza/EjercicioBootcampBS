package com.bootcampbssoft.springbootejercicio.repositories;


import com.bootcampbssoft.springbootejercicio.entidades.Personaje;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioPersonajes extends CrudRepository<Personaje, Integer> {
    public Personaje save(Personaje personaje);
    public List<Personaje> findAll();
    /*
    public List<Personaje> buscarPorNombre(String nombre);
    public List<Personaje> buscarPorEdad(int edad);

    public Personaje agregarPersonaje(Personaje personaje);
    public Personaje actualizarPersonajePorID(int id, Personaje personaje);
    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta);
    public boolean existeId(int id);
*/
}
