package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.CharactersMovies;
import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositoryMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        Movie m = this.iMovieRepository.save(movie);

        Optional<Movie> retuMovie = this.iMovieRepository.findById(m.getId());
        Movie mR = retuMovie.get();
        List<CharactersMovies> lChMo = mR.getCharactersMovies();
        for (CharactersMovies chMo: lChMo) {
            chMo.setMovie(m);
        }
        this.iMovieRepository.save(mR);
        return mR;
    }

    @Override
    public List<Movie> showAllMovies() {
        return this.iMovieRepository.findAll();
    }
    @Override
    public List<Movie> showMoviesByTitle(String title) {
        return this.iMovieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> showMovieByDateRange(LocalDate desde, LocalDate hasta) {
        return this.iMovieRepository.showMovieByDateRange(desde, hasta);
    }

    @Override
    public List<Movie> showMovieByRangeRating(int desde, int hasta) {
        return this.iMovieRepository.showMovieByRangeRating(desde,hasta);
    }

    @Override
    public Movie upDateMovie(int id, Movie movie) {
        Optional<Movie> oMovie = this.iMovieRepository.findById(id);

        if (oMovie.isPresent()){
            Movie mov = oMovie.get();
            mov.setTitle(movie.getTitle());
            mov.setReleaseDate(movie.getReleaseDate());
            mov.setRating(movie.getRating());

            return this.iMovieRepository.save(mov);
        }
        return null;
    }
}
