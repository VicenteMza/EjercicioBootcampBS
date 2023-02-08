package com.bootcampbssoft.springbootejercicio.entidades;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.util.List;

@Entity
@Table(name="generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_genero")
    private int idGen;
    @Column(name= "nombre", length=50)
    private String nombre;
   // @OneToMany()
    //@JoinColumn(name = "genero_id")
   @OneToMany(cascade = CascadeType.ALL,
           mappedBy = "generos")
   List<Genero> generos;

    //private Pelicula pelicula;
    public Genero() {
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

    public List<Genero> getGeneros () {
        return this.generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
