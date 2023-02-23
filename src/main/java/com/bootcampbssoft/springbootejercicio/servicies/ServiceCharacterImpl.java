package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import com.bootcampbssoft.springbootejercicio.entidades.CharactersMovies;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositoryCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCharacterImpl implements IServiceCharacter {
    @Autowired
    IRepositoryCharacter iCharacterRepository;

    @Override
    public Character createCharacter(Character character) {
        character.setName(character.getName().toUpperCase().trim());
        Character character1 = this.iCharacterRepository.save(character);

        Optional<Character> oCharacter = this.iCharacterRepository.findById(character1.getId());

            Character cR = oCharacter.get();
            List<CharactersMovies> lChMo = cR.getCharactersMovies();
            for (CharactersMovies chMo: lChMo) {
                chMo.setCharacter(character1);
            }

        return this.iCharacterRepository.save(cR);
    }

    @Override
    public List<Character> showAllCharacters() {

        return this.iCharacterRepository.findAll();
    }

    @Override
    public List<Character> searchCharacterByName(String name) {
        return this.iCharacterRepository.findByName(name);
    }

    @Override
    public List<Character> searchCharacterByAge(int age) {
        return this.iCharacterRepository.findByAge(age);
    }

    @Override
    public List<Character> showCharacterByAgeRange(int desde, int hasta) {
        return this.iCharacterRepository.findByAgeRange(desde,hasta);
    }

    @Override
    public Character updateCharacterByID(int id, Character character) {
        Optional<Character> oCharacter = this.iCharacterRepository.findById(id);

        if (oCharacter.isPresent()){
            Character ch = oCharacter.get();
            ch.setName(character.getName());
            ch.setAge(character.getAge());
            ch.setWeight(character.getWeight());
            ch.setHistory(character.getHistory());
            return this.iCharacterRepository.save(ch);
        }
        return null;
    }
}
