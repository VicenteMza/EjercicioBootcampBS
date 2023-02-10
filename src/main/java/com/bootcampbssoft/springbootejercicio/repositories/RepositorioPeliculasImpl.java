package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import com.bootcampbssoft.springbootejercicio.entidades.Personaje;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Deprecated
//@Repository
public class RepositorioPeliculasImpl{// implements IRepositorioPeliculas{
    /*
    private List<Pelicula> listaPeliculas;
    public RepositorioPeliculasImpl(){
        listaPeliculas = new ArrayList<>(
                Arrays.asList(
                new Pelicula(1,"Superman I",LocalDate.of(1979, Month.MAY,25), 4, new Personaje()),
                new Pelicula(2,"Batman", LocalDate.of(1989, Month.DECEMBER, 14), 5, new Personaje()),
                new Pelicula(3,"Shaun of the Dead", LocalDate.of(2004, Month.APRIL,9), 5,new Personaje()),
                new Pelicula(4,"Forever Young", LocalDate.of(1992, Month.DECEMBER,16), 2, new Personaje()),
                new Pelicula(5,"Citizen Kane", LocalDate.of(1941, Month.AUGUST,8), 5, new Personaje()),
                new Pelicula(6,"Alien", LocalDate.of(1979, Month.MAY,25), 5, new Personaje())
            ));
    }
    @Override
    public List<Pelicula> mostrarTodasLasPeliculas(){
        return this.listaPeliculas;
    }
    @Override
    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula p: listaPeliculas) {
            if (p.getTitulo().toLowerCase().trim().contains(titulo.toLowerCase().trim())){
                pelis.add(p);
            }
        }
        return pelis;
    }
    @Override
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta) {
        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula p: listaPeliculas) {
            if (p.getFecha().isAfter(desde) && p.getFecha().isBefore(hasta)){
                pelis.add(p);
            }
        }
        return pelis;
    }
    @Override
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta) {
        List<Pelicula> peli= new ArrayList<>();

        for (Pelicula p : listaPeliculas) {
            if (p.getCalificacion() >= desde && p.getCalificacion() <= hasta){
                peli.add(p);
            }
        }
        return peli;
    }

    @Override
    public Pelicula agregarPelicula(Pelicula pelicula) {
        pelicula.setIdPeli(listaPeliculas.size()+1);
        listaPeliculas.add(pelicula);
        return pelicula;
    }

    @Override
    public Pelicula actualizarPelicula(int id, Pelicula pelicula) {
        boolean condicion = true;

        for (Pelicula peli: listaPeliculas) {
            if (peli.getIdPeli() == id){
                peli.setTitulo(pelicula.getTitulo());
                peli.setCalificacion(pelicula.getCalificacion());
                peli.setFecha(pelicula.getFecha());
                //peli.setPersonaje(pelicula.getPersonaje());
                condicion = false;
                break;
            }
        }
        if (condicion){
            pelicula = null;
        }
        return pelicula;
    }
    public boolean peliculaRepetida(Pelicula pelicula){
        boolean repetido = false;
        for (Pelicula peli: this.listaPeliculas) {
            boolean tituloPeli = peli.getTitulo().trim().equalsIgnoreCase(pelicula.getTitulo().trim());
            boolean fechaPeli = peli.getFecha().isEqual(pelicula.getFecha());

            if (tituloPeli && fechaPeli){
                repetido = true;
            }
        }
        return repetido;
    }
    @Override
    public boolean idExiste (int id){
        return listaPeliculas.stream()
                .filter(gen -> gen.getIdPeli() == id)
                .findFirst()
                .isPresent();
    }
*/
}
