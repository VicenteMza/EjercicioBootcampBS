package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRepositoryMovie extends CrudRepository<Movie, Integer> {
    Movie save(Movie movie);
    List<Movie> findAll();
    @Query("select p from Movie p where title = ?1")
    public Optional<Movie> findByTitle(String title);

    public Optional<Movie> findById(Integer id);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) = LOWER(:title) AND m.releaseDate = :releaseDate")
    Optional<Movie> findByTitleAndReleaseDate(String title, LocalDate releaseDate);
    //@Modifying
    //@Transactional
    //@Query(value = "insert into peliculas_personajes (personajes_id, peliculas_id) values (?,?)",  nativeQuery = true)
    //public Optional<?> savePersoPeli(int idPerso, int idPeli);
    /*

    public List<Movie> mostrarTodasLasPeliculaPorTitulo(String titulo);
    public List<Movie> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta);
    public List<Movie> mostrarPeliculaPorRangoCalificacion(int desde, int hasta);

    public Movie actualizarPelicula(int id, Movie pelicula);
    public boolean peliculaRepetida(Movie pelicula);
    public boolean idExiste (int id);
     */
}
