package com.bootcampbssoft.springbootejercicio.entidadesDTO;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.entidades.Personaje;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class PeliculaDTO {
    private int idPeli;
    private String titulo;
    private LocalDate fecha;
    private int calificacion;
    private int id_genero;

    public PeliculaDTO(String titulo, LocalDate fecha, int calificacion, int id_genero) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.id_genero = id_genero;
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

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    @Override
    public String toString() {
        return "PeliculaDTO{" +
                "id=" + idPeli +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", calificacion=" + calificacion +
                ", id_genero=" + id_genero +
                '}';
    }
}
