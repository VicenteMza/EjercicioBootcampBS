package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Personaje;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioEntiPersonajes extends CrudRepository<Personaje, Integer> {
}
