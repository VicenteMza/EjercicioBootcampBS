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
    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties(value = {"movies"})
    //@JsonManagedReference
    private List<Character> characters;
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

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idPeli=" + id +
                ", titulo='" + title + '\'' +
                ", fecha=" + releaseDate +
                ", calificacion=" + rating +
                ", personajes=" + characters +
                ", genero=" + genre +
                '}';
    }
}
