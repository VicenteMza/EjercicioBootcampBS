package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;

import java.util.List;

public interface IServiceMovie {
    public Movie createMovie(Movie movie);
    public List<Movie> showAllMovies();

    /*

    public List<Movie> mostrarTodasLasPeliculaPorTitulo(String titulo);
    public List<Movie> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta);
    public List<Movie> mostrarPeliculaPorRangoCalificacion(int desde, int hasta);
    public Movie agregarPelicula(Movie pelicula);
    public Movie actualizarPelicula(int id, Movie pelicula);
*/
}
