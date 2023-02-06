package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ServicioPeliculasImpl implements IServicioPeliculas{
    @Autowired
    private IRepositorioPeliculas repoPelicula;

    @Override
    public List<Pelicula> mostrarTodasLasPeliculas() {
        return this.repoPelicula.mostrarTodasLasPeliculas();
    }

    @Override
    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        return this.repoPelicula.mostrarTodasLasPeliculaPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoDeFecha(desde, hasta);
    }

    @Override
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoCalificacion(desde,hasta);
    }

    @Override
    public Pelicula agregarPelicula(Pelicula pelicula) {
        if (this.repoPelicula.peliculaRepetida(pelicula)){
            return null;
        }
        return this.repoPelicula.agregarPelicula(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(int id, Pelicula pelicula) {

        if(!this.repoPelicula.idNoExiste(id) && id > 0 && this.repoPelicula.peliculaRepetida(pelicula)){
            return null;
        }
        return this.repoPelicula.actualizarPelicula(id, pelicula);
    }

}
