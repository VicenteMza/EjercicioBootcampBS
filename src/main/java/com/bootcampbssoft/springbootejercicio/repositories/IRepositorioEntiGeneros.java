package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioEntiGeneros extends CrudRepository<Genero, Integer> {
    //@Query(INSERT INTO generos VALUES ( valor1, valor2 , ...))
   // @Query("INSERT INTO generos VALUES ")
    //public Genero agregarGenero(Genero genero);
}
