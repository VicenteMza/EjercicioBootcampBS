package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IRepositorioGeneros extends CrudRepository<Genero, Integer> {
    public Genero save(Genero genero);
    public List<Genero> findAll();
    @Override
    Optional<Genero> findById(Integer integer);
    Optional<Genero> findById(int id);
    @Query("select nombre from Genero where nombre = ?1")
    public Optional<Genero> findByName(String nombre);

}
