package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioEntiPeliculas extends CrudRepository<Pelicula, Integer> {
}
