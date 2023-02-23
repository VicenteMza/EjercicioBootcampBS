package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Character;

import java.util.List;

public interface IServiceCharacter {
    public Character createCharacter(Character character);
    public List<Character> showAllCharacters();
    public List<Character> searchCharacterByName(String name);
    public List<Character> searchCharacterByAge(int age);
    public List<Character> showCharacterByAgeRange(int desde, int hasta);
    public Character updateCharacterByID(int id, Character personaje);
}
