package com.bootcampbssoft.springbootejercicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

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
    @Column(name= "edad")
    private int edad;
    @Column(name= "peso")
    private Double peso;
    @Column(name= "historia", length=500)
    private String historia;
    @ManyToMany
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "personajes_id", referencedColumnName="id_personaje"),
            inverseJoinColumns = @JoinColumn(name = "peliculas_id", referencedColumnName="id_peli")
    )
    @JsonIgnoreProperties({"personajes"})
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

    @Override
    public String toString() {
        return "Personaje{" +
                "idPer=" + idPer +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", peliculas=" + peliculas +
                '}';
    }
}
