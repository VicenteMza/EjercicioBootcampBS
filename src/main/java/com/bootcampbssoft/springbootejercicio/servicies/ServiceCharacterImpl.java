package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositoryCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCharacterImpl implements IServiceCharacter {
    @Autowired
    IRepositoryCharacter iCharacterRepository;

    @Override
    public Character createCharacter(Character character) {
        character.setName(character.getName().toUpperCase().trim());

        return this.iCharacterRepository.save(character);
    }

    @Override
    public List<Character> showAllCharacters() {

        return this.iCharacterRepository.findAll();
    }
    /*

    @Override
    public List<Character> buscarPorNombre(String nombre) {
        return iRpersonajes.buscarPorNombre(nombre);
    }

    @Override
    public List<Character> buscarPorEdad(int edad) {
        return iRpersonajes.buscarPorEdad(edad);
    }
    @Override
    public List<Character> mostrarPersonajePorRangoDeEdad(int desde, int hasta) {
        return iRpersonajes.mostrarPersonajePorRangoDeEdad(desde,hasta);
    }



    @Override
    public Character actualizarPersonajePorID(int id, Character personaje) {
        if (!this.iRpersonajes.existeId(id)){
            return null;
        }
        return iRpersonajes.actualizarPersonajePorID(id,personaje);
    }
     */
}
