package com.bootcampbssoft.springbootejercicio.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.catalina.users.GenericRole;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_peli")
    private int idPeli;
    @Column(name= "titulo", length=50)
    private String titulo;
    @Column(name="fecha_estreno")
    private LocalDate fecha;
    @Column(name= "calificacion")
    private int calificacion;
    @ManyToMany()
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "peliculas_id", referencedColumnName="id_peli"),
            inverseJoinColumns = @JoinColumn(name = "personajes_id", referencedColumnName="id_personaje")
    )
    @JsonIgnoreProperties(value="peliculas")
    private List<Personaje> personajes;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_genero",referencedColumnName="id_gen")
    @JsonIgnoreProperties(value="peliculas")
    private Genero genero;

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPeli=" + idPeli +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", calificacion=" + calificacion +
                ", personajes=" + personajes +
                ", genero=" + genero +
                '}';
    }
}
