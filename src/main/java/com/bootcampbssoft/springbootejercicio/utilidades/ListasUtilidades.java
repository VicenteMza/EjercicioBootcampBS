package com.bootcampbssoft.springbootejercicio.utilidades;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;
import com.bootcampbssoft.springbootejercicio.dominio.Personaje;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListasUtilidades {
    private List<Pelicula> listaPeliculas;
    private List<Personaje> listaPersonajes;
    private List<Genero> listaGeneros;

    public ListasUtilidades(){
        this.listaPersonajes= new ArrayList<>(
                Arrays.asList(
                        new Personaje(1,"Clark Kent", 30,90.2,"Extraterrestre, ultimo sobreviviente " +
                                "del Planeta Crypton.",new Pelicula() ),
                        new Personaje(2,"Bruce Wayne", 29,90.0,"Humano que usa la inteligencia y fortuna " +
                                "para luchar contra el crimen en Ghotam",new Pelicula() ),
                        new Personaje(3,"Shaun", 29,85.0,"un vendedor de productos electrónicos que " +
                                "vive en Londres, inmerso en la rutina de la ciudad, debe luchar contra zombies", new Pelicula(3,"Shaun of the Dead",LocalDate.of(2004, Month.APRIL,9), 5,new Personaje())),
                        new Personaje(4,"Daniel McCormick", 25,75.0,"Daniel McCormick, piloto" +
                                " de pruebas, es un hombre al que todo le va bien en la vida. Todo cambia una mañana en la que su novia," +
                                " tiene un accidente. Desolado, se ofrece voluntario para un experimento" +
                                " secreto: El cuerpo de Daniel queda congelado por 50 años en una cápsula experimental. ",
                                new Pelicula()),
                        new Personaje(5,"Charles Foster Kane",80,70.5,"Un magnate de la prensa estadounidense " +
                                "enormemente rico que ha estado viviendo solo en Florida en su suntuosa finca Xanadu durante los últimos años" +
                                " de su vida. Muere en la cama pronunciando la palabra «Rosebud...»",
                                new Pelicula()),
                        new Personaje(6,"Ellen Ripley", 28,65.0,"La tripulación del remolcador espacial Nostromo" +
                                " atiende una señal de socorro y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.",
                                new Pelicula())
                )
        );

        this.listaPeliculas = new ArrayList<>(
                Arrays.asList(
                        new Pelicula(1,"Superman I", LocalDate.of(1979, Month.MAY,25), 4, new Personaje()),
                        new Pelicula(2,"Batman", LocalDate.of(1989, Month.DECEMBER, 14), 5, new Personaje()),
                        new Pelicula(3,"Shaun of the Dead", LocalDate.of(2004, Month.APRIL,9), 5,new Personaje()),
                        new Pelicula(4,"Forever Young", LocalDate.of(1992, Month.DECEMBER,16), 2, new Personaje()),
                        new Pelicula(5,"Citizen Kane", LocalDate.of(1941, Month.AUGUST,8), 5, new Personaje()),
                        new Pelicula(6,"Alien", LocalDate.of(1979, Month.MAY,25), 5, new Personaje())
                )
        );

        this.listaGeneros = new ArrayList<>(
                Arrays.asList(
                        new Genero(1,"Accion",listaPeliculas.get(0)),
                        new Genero(2,"Accion",listaPeliculas.get(1)),
                        new Genero(3, "Comedia",listaPeliculas.get(2)),
                        new Genero(4,"Romance",listaPeliculas.get(3)),
                        new Genero(5,"Drama",listaPeliculas.get(4)),
                        new Genero(6,"Terror", listaPeliculas.get(5))
                )
        );
    }

    public List<Personaje> buscarPorNombre(String nombre){
        String nom = nombre.toLowerCase();
        List<Personaje> personajes = new ArrayList<>();

        for (Personaje perso: listaPersonajes) {
            if (perso.getNombre().toLowerCase().contains(nom)){
                personajes.add(perso);
                /*per.setNombre(perso.getNombre());
                per.setEdad(perso.getEdad());
                per.setHistoria(perso.getHistoria());
                per.setPeso(perso.getPeso());
                per.setPelicula(perso.getPelicula());*/
            }
        }
        return personajes;
    }

    public List<Personaje> listarPersonajes(){

        return this.listaPersonajes;
    }

    public List<Personaje> buscarPorEdad(int edad) {
        List<Personaje> perso = new ArrayList<>();

        for (Personaje per : listaPersonajes) {
            if (per.getEdad() == edad){
                perso.add(per);
            }
        }

        return perso;
    }

    public List<Pelicula> mostrarTodasLasPeliculas(){

        return this.listaPeliculas;
    }

    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        String titu = titulo.toLowerCase();
        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula p: listaPeliculas) {
            if (p.getTitulo().toLowerCase().contains(titu)){
                pelis.add(p);
            }
        }
        return pelis;
    }

    public List<Pelicula> mostrarPeliculaPorGenero(String genero) {
        List<Pelicula> peli= new ArrayList<>();
        String gen = genero.toLowerCase();

        for (Genero g : listaGeneros) {
            if (g.getNombre().toLowerCase().contains(gen)){
                peli.add(g.getPelicula());
            }
        }
        return peli;
    }
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta) {
        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula p: listaPeliculas) {
            if (p.getFecha().isAfter(desde) && p.getFecha().isBefore(hasta)){
                pelis.add(p);
            }
        }
        return pelis;
    }

    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta) {
         List<Pelicula> peli= new ArrayList<>();

        for (Pelicula p : listaPeliculas) {
            if (p.getCalificacion() >= desde && p.getCalificacion() <= hasta){
                peli.add(p);
            }
        }
        return peli;
    }

    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta) {
        List<Personaje> perso = new ArrayList<>();

        for (Personaje p: listaPersonajes){

            if (p.getEdad() >= desde && p.getEdad() <= hasta){
                perso.add(p);
            }
        }
        return perso;
    }

    public Pelicula agregarPelicula(Pelicula pelicula) {
        pelicula.setIdPeli(listaPeliculas.size()+1);
        listaPeliculas.add(pelicula);
        return pelicula;
    }

    public Personaje agregarPersonaje(Personaje personaje) {
        personaje.setIdPer(listaPersonajes.size()+1);
        listaPersonajes.add(personaje);
        return personaje;
    }

    public Genero agregarGeneroDePelicula(Genero genero) {
        genero.setIdGen(listaGeneros.size()+1);
        listaGeneros.add(genero);
        System.out.println("Tamaño de la lista: " + listaGeneros.size());
        return genero;
    }
    public Pelicula actualizarPelicula(int id, Pelicula pelicula) {
        System.out.println("Id: "+ id + "\nPelicula: "+ pelicula);
        boolean condicion = true;

        for (Pelicula peli: listaPeliculas) {
            if (peli.getIdPeli() == id){
                peli.setTitulo(pelicula.getTitulo());
                peli.setCalificacion(pelicula.getCalificacion());
                peli.setFecha(pelicula.getFecha());
                peli.setPersonaje(pelicula.getPersonaje());
                condicion = false;
                break;
            }
        }
        if (condicion){
            pelicula = null;
        }
        return pelicula;
    }

    public Personaje actualizarPersonajePorID(int id, Personaje personaje) {
        System.out.println("Id: "+ id + "\nPersonaje: "+ personaje);
        Personaje p = new Personaje();

        for (Personaje per: listaPersonajes) {
            if (per.getIdPer() == id){
                per.setNombre(personaje.getNombre());
                per.setEdad(personaje.getEdad());
                per.setPeso(personaje.getPeso());
                per.setHistoria(personaje.getHistoria());
                per.setPelicula(personaje.getPelicula());
                p = per;
                break;
            }else {
                p = null;
            }
        }
        return p;
    }

    public Genero actulizarGeneroPorId(int id, Genero genero) {
        Boolean condicion = true;

        for (Genero gen: listaGeneros) {
            if (gen.getIdGen() == id){
                gen.setNombre(genero.getNombre());
                condicion = false;
                break;
            }
        }
        if (condicion){
            return null;
        }
        System.out.println(listaGeneros.get(id-1));
        return genero;
    }

    public List<Genero> mostrarListaDeGeneros() {
        return this.listaGeneros;
    }
}
