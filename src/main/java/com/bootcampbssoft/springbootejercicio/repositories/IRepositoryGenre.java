package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IRepositoryGenre extends CrudRepository<Genre, Integer> {
    public Genre save(Genre genre);
    public List<Genre> findAll();
    public Optional<Genre> findById(Integer id);
    public Optional<Genre> findById(int id);
    @Query("select name from Genre where name = ?1")
    public Optional<Genre> findByName(String name);

}
