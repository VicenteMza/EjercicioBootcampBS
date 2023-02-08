package com.bootcampbssoft.springbootejercicio.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class Personaje {

    private int idPer;
    private String nombre;
    private int edad;
    private Double peso;
    private String historia;
    private Pelicula pelicula;
    public Personaje() {
    }

    public Personaje(int idPer, String nombre, int edad, Double peso, String historia, Pelicula pelicula) {
        this.idPer = idPer;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.pelicula = pelicula;
    }

    public int getIdPer() {
        return idPer;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }


    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "idPer=" + idPer +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", peliculas=" + pelicula +
                '}';
    }
}
