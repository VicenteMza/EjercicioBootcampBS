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
    //Relacion con CharactersMovies
    @OneToMany(mappedBy = "character",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"character"})
    private List<CharactersMovies> charactersMovies;
  
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

    public List<CharactersMovies> getCharactersMovies() {
        return charactersMovies;
    }

    public void setCharactersMovies(List<CharactersMovies> charactersMovies) {
        this.charactersMovies = charactersMovies;
    }
}
