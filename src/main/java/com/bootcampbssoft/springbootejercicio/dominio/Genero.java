package com.bootcampbssoft.springbootejercicio.dominio;

public class Genero {
    private String nombre;
    private Pelicula pelicula;

    public Genero(String nombre, Pelicula pelicula) {
        this.nombre = nombre;
        this.pelicula = pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
