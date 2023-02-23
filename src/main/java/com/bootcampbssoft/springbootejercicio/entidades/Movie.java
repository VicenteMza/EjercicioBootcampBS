package com.bootcampbssoft.springbootejercicio.entidades;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="movies")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movie")
    private int id;
    @Column(name= "title", length=50)
    private String title;
    @Column(name="release_date")
    private LocalDate releaseDate;
    @Column(name= "rating")
    private int rating;
    //Relacion con CharactersMovies
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "movie")
    @JsonIgnoreProperties(value = "movie")
    private List<CharactersMovies> charactersMovies;
    //relacion con Genre
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id_genre")
    @JsonIgnoreProperties(value = "movies")
    private Genre genre;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<CharactersMovies> getCharactersMovies() {
        return charactersMovies;
    }

    public void setCharactersMovies(List<CharactersMovies> charactersMovies) {
        this.charactersMovies = charactersMovies;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
