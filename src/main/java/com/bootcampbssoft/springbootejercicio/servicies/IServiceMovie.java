package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genre;
import com.bootcampbssoft.springbootejercicio.entidades.Movie;

import java.time.LocalDate;
import java.util.List;

public interface IServiceMovie {
    public Movie createMovie(Movie movie);
    public List<Movie> showAllMovies();
    public List<Movie> showMoviesByTitle(String title);
    public List<Movie> showMovieByDateRange(LocalDate desde, LocalDate hasta);
    public List<Movie> showMovieByRangeRating(int desde, int hasta);
    public Movie upDateMovie(int id, Movie movie);

}
