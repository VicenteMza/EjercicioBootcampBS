package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryCharacter extends CrudRepository<Character, Integer> {

    public Character save(Character character);
    public List<Character> findAll();
    /*
    public List<Character> buscarPorNombre(String nombre);
    public List<Character> buscarPorEdad(int edad);


    public Character actualizarPersonajePorID(int id, Character personaje);
    public List<Character> mostrarPersonajePorRangoDeEdad(int desde, int hasta);
    public boolean existeId(int id);
     */
}
