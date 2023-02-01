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
        this. listaPersonajes= new ArrayList<>(
                Arrays.asList(
                        new Personaje("Clark Kent", "30",90.2,"Extraterrestre, ultimo sobreviviente " +
                                "del Planeta Crypton.",new Pelicula() ),
                        new Personaje("Batman", "29",90.0,"Humano que usa la inteligencia y fortuna " +
                                "para luchar contra el crimen en Ghotam",new Pelicula() ),
                        new Personaje("Shaun", "29",85.0,"un vendedor de productos electrónicos que " +
                                "vive en Londres, inmerso en la rutina de la ciudad, debe luchar contra zombies", new Pelicula("Shaun of the Dead",LocalDate.of(2004, Month.APRIL,9), 5,new Personaje())),
                        new Personaje("Daniel McCormick", "25",75.0,"Daniel McCormick, piloto" +
                                " de pruebas, es un hombre al que todo le va bien en la vida. Todo cambia una mañana en la que su novia," +
                                " tiene un accidente. Desolado, se ofrece voluntario para un experimento" +
                                " secreto: El cuerpo de Daniel queda congelado por 50 años en una cápsula experimental. ",
                                new Pelicula())
                )
        );

        this.listaPeliculas = new ArrayList<>(
                Arrays.asList(
                        new Pelicula("Superman I", LocalDate.of(1979, Month.MAY,25), 4, new Personaje()),
                        new Pelicula("Batman", LocalDate.of(1989, Month.DECEMBER, 14), 5, new Personaje()),
                        new Pelicula("Shaun of the Dead", LocalDate.of(2004, Month.APRIL,9), 5,new Personaje()),
                        new Pelicula("Forever Young", LocalDate.of(1992, Month.DECEMBER,16), 2, new Personaje())
                )
        );

        this.listaGeneros = new ArrayList<>(
                Arrays.asList(
                        new Genero("Accion",listaPeliculas.get(0)),
                        new Genero("Accion",listaPeliculas.get(1)),
                        new Genero("Comedia",listaPeliculas.get(2)),
                        new Genero("Romance",listaPeliculas.get(3))
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
        return listaPersonajes;
    }

    public List<Personaje> buscarPorEdad( String edad) {
        List<Personaje> perso = new ArrayList<>();

        for (Personaje per : listaPersonajes) {
            if (edad.equals(per.getEdad())){
                perso.add(per);
            }
        }

        return perso;
    }

    public List<Pelicula> mostrarTodasLasPeliculas(){
        return listaPeliculas;
    }

    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        String titu = titulo.toLowerCase();
        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula p: listaPeliculas) {
            if (p.getTitulo().toLowerCase().contains(titu)){
                //peli = new Pelicula();
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
                System.out.println(g.getPelicula());
            }
        }
        return peli;
    }
}