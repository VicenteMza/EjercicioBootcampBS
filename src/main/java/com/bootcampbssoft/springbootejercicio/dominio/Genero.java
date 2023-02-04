package com.bootcampbssoft.springbootejercicio.dominio;

public class Genero {
    private int idGen;
    private String nombre;
    private Pelicula pelicula;

    public Genero() {
    }

    public Genero(int id, String nombre, Pelicula pelicula) {
        this.idGen = id;
        this.nombre = nombre;
        this.pelicula = pelicula;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
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

    @Override
    public String toString() {
        return "Genero{" +
                "idGen=" + idGen +
                ", nombre='" + nombre + '\'' +
                ", pelicula=" + pelicula +
                '}';
    }
}
