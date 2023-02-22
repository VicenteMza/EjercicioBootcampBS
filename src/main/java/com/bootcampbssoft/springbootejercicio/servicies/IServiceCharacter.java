package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Character;

import java.util.List;

public interface IServiceCharacter {
    public Character createCharacter(Character character);
    public List<Character> showAllCharacters();
    /*
    public List<Character> buscarPorNombre(String nombre);
    public List<Character> buscarPorEdad(int edad);


    public Character actualizarPersonajePorID(int id, Character personaje);
    public List<Character> mostrarPersonajePorRangoDeEdad(int desde, int hasta);
     */
}
