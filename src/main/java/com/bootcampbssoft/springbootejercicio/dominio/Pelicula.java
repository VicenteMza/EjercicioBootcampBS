package com.bootcampbssoft.springbootejercicio.dominio;

import java.time.LocalDate;
public class Pelicula {
    private String titulo;
    private LocalDate fecha;
    private int calificacion;
    private Personaje personaje;

    public Pelicula() {
    }

    public Pelicula(String titulo, LocalDate fecha, int calificacion, Personaje personaje) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.personaje = personaje;
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
