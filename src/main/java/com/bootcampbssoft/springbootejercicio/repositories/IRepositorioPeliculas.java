package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import com.bootcampbssoft.springbootejercicio.entidadesDTO.PeliculaDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRepositorioPeliculas extends CrudRepository<Pelicula, Integer> {
    //@Query("insert into peliculas (titulo, fecha_estreno, calificacion, id_genero) values (?1, ?2, ?3, ?4)")
    public Pelicula save(Pelicula pelicula);
    public List<Pelicula> findAll();
    @Query("select titulo from Pelicula where titulo = ?1")
    public Optional<Pelicula> buscarPorNombre(String titulo);



    /*
    public List<Pelicula> mostrarTodasLasPeliculas();
    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo);
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta);
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta);

    public Pelicula actualizarPelicula(int id, Pelicula pelicula);
    public boolean peliculaRepetida(Pelicula pelicula);
    public boolean idExiste (int id);
     */
}
