package com.bootcampbssoft.springbootejercicio.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
public class Pelicula {

    private int idPeli;
    private String titulo;
    private LocalDate fecha;
    private int calificacion;
    private Personaje personaje;//para la relacion ManyToMany se debe crear un una List

    public Pelicula() {
    }

    public Pelicula(int idPeli, String titulo, LocalDate fecha, int calificacion, Personaje personaje) {
        this.idPeli = idPeli;
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.personaje = personaje;
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

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
