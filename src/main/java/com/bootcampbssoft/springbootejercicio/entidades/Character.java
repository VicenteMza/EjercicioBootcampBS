package com.bootcampbssoft.springbootejercicio.entidades;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="characters")
public class Character implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_character")
    private int id;
    @Column(name= "name", length=50)
    private String name;
    @Column(name= "age")
    private int age;
    @Column(name= "weight")
    private Double weight;
    @Column(name= "history", length=500)
    private String history;
    @ManyToMany (cascade = {CascadeType.MERGE,
                            CascadeType.REFRESH},
                            fetch = FetchType.LAZY)
    @JoinTable(
            name = "movies_characters",
            joinColumns = @JoinColumn(name = "characters_id", referencedColumnName = "id_character"),
            inverseJoinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id_movie")
    )
    @JsonIgnoreProperties(value="characters")
    //@JsonBackReference
    private List<Movie> movies;
  
    public Character() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "idPer=" + id +
                ", nombre='" + name + '\'' +
                ", edad=" + age +
                ", peso=" + weight +
                ", historia='" + history + '\'' +
                ", peliculas=" + movies +
                '}';
    }
}
