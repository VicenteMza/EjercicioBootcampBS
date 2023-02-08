package com.bootcampbssoft.springbootejercicio.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

import java.util.List;

@Entity
@Table(name="personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_personaje")
    private int idPer;
    @Column(name= "nombre", length=50)
    private String nombre;
    @Column(name= "edad", length=3)//esto le da solo 3 numeros de ingreso?
    private int edad;
    @Column(name= "peso")
    private Double peso;
    @Column(name= "historia", length=500)
    private String historia;
    //private Pelicula pelicula;
    @ManyToMany(mappedBy = "personajes",
            fetch = FetchType.LAZY
    )
    private List<Pelicula> peliculas;

    public Personaje() {
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

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
