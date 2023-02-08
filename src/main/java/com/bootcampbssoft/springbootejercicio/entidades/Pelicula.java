package com.bootcampbssoft.springbootejercicio.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_peicula")
    private int idPeli;
    @Column(name= "titulo", length=50)
    private String titulo;
    @Column(name="fecha_estreno")
    private LocalDate fecha;
    @Column(name= "calificacion")
    private int calificacion;
    //private Personaje personaje;
    @ManyToMany()
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "personajes_id")
    )
    private List<Personaje> personajes;

    @ManyToOne
    @JoinColumn(name = "fk_genero")
    private Genero genero;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pelicula() {
    }

    public int getIdPeli() {
        return idPeli;
    }

    public void setIdPeli(int idPeli) {
        this.idPeli = idPeli;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    //public Pelicula getPelicula() {
    //    return pelicula;
    //}

    //public void setPelicula(Pelicula peliculas) {
    //    this.pelicula = peliculas;
    //}
}
