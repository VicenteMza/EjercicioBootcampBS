package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRepositoryMovie extends CrudRepository<Movie, Integer> {
    Movie save(Movie movie);
    List<Movie> findAll();
    //@Query("select p from Movie p where title = ?1")
    //public Optional<Movie> findByTitle(String title);

    public Optional<Movie> findById(Integer id);

    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) = LOWER(:title) AND m.releaseDate = :releaseDate")
    Optional<Movie> findByTitleAndReleaseDate(String title, LocalDate releaseDate);
    @Query("SELECT u FROM Movie u WHERE LOWER(u.title) LIKE LOWER(concat('%', :title, '%'))")
    List<Movie> findByTitle(String title);
    @Query("SELECT m FROM Movie m WHERE m.releaseDate BETWEEN :desde AND :hasta")
    public List<Movie> showMovieByDateRange(@Param("desde") LocalDate desde, @Param("hasta") LocalDate hasta);
    @Query("SELECT m FROM Movie m WHERE m.rating BETWEEN :desde AND :hasta")
    public List<Movie> showMovieByRangeRating(int desde, int hasta);
    @Query("SELECT m FROM Movie m WHERE m.genre.id = :idGenre")
    public List<Movie> findByGenreId(@Param("idGenre") int id);
}
