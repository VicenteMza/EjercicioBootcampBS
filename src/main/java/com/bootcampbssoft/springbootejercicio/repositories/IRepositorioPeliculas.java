package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IRepositorioPeliculas extends CrudRepository<Pelicula, Integer> {
    Pelicula save(Pelicula pelicula);
    List<Pelicula> findAll();
    @Query("select p from Pelicula p where titulo = ?1")
    public Optional<Pelicula> findByTitle(String titulo);

    @Override
    Optional<Pelicula> findById(Integer integer);
    @Modifying
    @Transactional
    @Query(value = "insert into peliculas_personajes (personajes_id, peliculas_id) values (?,?)",  nativeQuery = true)
    public Optional<?> savePersoPeli(int idPerso, int idPeli);
    /*

    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo);
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta);
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta);

    public Pelicula actualizarPelicula(int id, Pelicula pelicula);
    public boolean peliculaRepetida(Pelicula pelicula);
    public boolean idExiste (int id);
     */
}
