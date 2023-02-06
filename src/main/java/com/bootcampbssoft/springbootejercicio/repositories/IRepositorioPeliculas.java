package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;

import java.time.LocalDate;
import java.util.List;

public interface IRepositorioPeliculas {
    public List<Pelicula> mostrarTodasLasPeliculas();
    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo);
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta);
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta);
    public Pelicula agregarPelicula(Pelicula pelicula);
    public Pelicula actualizarPelicula(int id, Pelicula pelicula);
    public boolean peliculaRepetida(Pelicula pelicula);
    public boolean idExiste (int id);
}
