package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositoryMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMovieImpl implements IServiceMovie {
    @Autowired
    private IRepositoryMovie iMovieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        Optional<Movie> mov = this.iMovieRepository.findByTitleAndReleaseDate(movie.getTitle(), movie.getReleaseDate());
        System.out.println(mov.isPresent());

        if (mov.isPresent()){
            throw new RuntimeException("Titulo: "+movie.getTitle()+ ", Fecha: "+movie.getReleaseDate() +" existente!");
        }
        movie.setTitle(movie.getTitle().toUpperCase().trim());
        return this.iMovieRepository.save(movie);
    }

    @Override
    public List<Movie> showAllMovies() {
        return this.iMovieRepository.findAll();
    }

    /*




    @Override
    public List<Movie> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        return this.repoPelicula.mostrarTodasLasPeliculaPorTitulo(titulo);
    }

    @Override
    public List<Movie> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoDeFecha(desde, hasta);
    }

    @Override
    public List<Movie> mostrarPeliculaPorRangoCalificacion(int desde, int hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoCalificacion(desde,hasta);
    }



    @Override
    public Movie actualizarPelicula(int id, Movie pelicula) {
        System.out.println(!this.repoPelicula.idExiste(id));
        System.out.println(this.repoPelicula.peliculaRepetida(pelicula));
        System.out.println("-----------------------------");

        if(!this.repoPelicula.idExiste(id) || this.repoPelicula.peliculaRepetida(pelicula)){
            return null;
        }
        return this.repoPelicula.actualizarPelicula(id, pelicula);
    }
    */
}
