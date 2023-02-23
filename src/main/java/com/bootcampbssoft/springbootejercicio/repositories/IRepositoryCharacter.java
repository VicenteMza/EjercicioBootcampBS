package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRepositoryCharacter extends CrudRepository<Character, Integer> {

    public Character save(Character character);
    public List<Character> findAll();
    @Query("SELECT u FROM Character u WHERE LOWER(u.name) LIKE LOWER(concat('%', :name, '%'))")
    public List<Character> findByName(String name);
    public List<Character> findByAge(int age);
    @Query("SELECT c FROM Character c WHERE c.age BETWEEN :desde AND :hasta")
    public List<Character> findByAgeRange(@Param("desde") int desde, @Param("hasta") int hasta);
    public Optional<Character> findById(int id);
}
