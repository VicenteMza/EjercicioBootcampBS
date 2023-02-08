package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;
import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class RepositorioPersonajesImpl implements IRepositorioPersonajes{
    private List<Personaje> listaPersonajes;

    public RepositorioPersonajesImpl() {

        this.listaPersonajes = new ArrayList<>(
                Arrays.asList(
                        new Personaje(1, "Clark Kent", 30, 90.2, "Extraterrestre, ultimo sobreviviente " +
                                "del Planeta Crypton.", new Pelicula()),
                        new Personaje(2, "Bruce Wayne", 29, 90.0, "Humano que usa la inteligencia y fortuna " +
                                "para luchar contra el crimen en Ghotam", new Pelicula()),
                        new Personaje(3, "Shaun", 29, 85.0, "un vendedor de productos electrónicos que " +
                                "vive en Londres, inmerso en la rutina de la ciudad, debe luchar contra zombies", new Pelicula(3, "Shaun of the Dead", LocalDate.of(2004, Month.APRIL, 9), 5, new Personaje())),
                        new Personaje(4, "Daniel McCormick", 25, 75.0, "Daniel McCormick, piloto" +
                                " de pruebas, es un hombre al que todo le va bien en la vida. Todo cambia una mañana en la que su novia," +
                                " tiene un accidente. Desolado, se ofrece voluntario para un experimento" +
                                " secreto: El cuerpo de Daniel queda congelado por 50 años en una cápsula experimental. ",
                                new Pelicula()),
                        new Personaje(5, "Charles Foster Kane", 80, 70.5, "Un magnate de la prensa estadounidense " +
                                "enormemente rico que ha estado viviendo solo en Florida en su suntuosa finca Xanadu durante los últimos años" +
                                " de su vida. Muere en la cama pronunciando la palabra «Rosebud...»",
                                new Pelicula()),
                        new Personaje(6, "Ellen Ripley", 28, 65.0, "La tripulación del remolcador espacial Nostromo" +
                                " atiende una señal de socorro y, sin saberlo, sube a bordo una letal forma de vida extraterrestre.",
                                new Pelicula())
                )
        );
    }
    @Override
    public List<Personaje> buscarPorNombre(String nombre){
        String nom = nombre.toLowerCase().trim();
        List<Personaje> personajes = new ArrayList<>();

        for (Personaje perso: listaPersonajes) {
            if (perso.getNombre().toLowerCase().trim().contains(nom)){
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
    @Override
    public List<Personaje> buscarPorEdad(int edad) {
        List<Personaje> perso = new ArrayList<>();

        for (Personaje per : listaPersonajes) {
            if (per.getEdad() == edad){
                perso.add(per);
            }
        }
        return perso;
    }
    @Override
    public List<Personaje> mostrarPersonajePorRangoDeEdad(int desde, int hasta) {
        List<Personaje> perso = new ArrayList<>();

        for (Personaje p: listaPersonajes){
            if (p.getEdad() >= desde && p.getEdad() <= hasta){
                perso.add(p);
            }
        }
        return perso;
    }
    @Override
    public Personaje agregarPersonaje(Personaje personaje) {
        personaje.setIdPer(listaPersonajes.size()+1);
        listaPersonajes.add(personaje);
        return personaje;
    }
    @Override
    public List<Personaje> mostrarTodosLosPersonajes(){
        return this.listaPersonajes;
    }

    @Override
    public Personaje actualizarPersonajePorID(int id, Personaje personaje) {
        Personaje p = new Personaje();

        for (Personaje per: listaPersonajes) {
            if (per.getIdPer() == id){
                per.setNombre(personaje.getNombre());
                per.setEdad(personaje.getEdad());
                per.setPeso(personaje.getPeso());
                per.setHistoria(personaje.getHistoria());
                //per.setPelicula(personaje.getPelicula());
                p = per;
                break;
            }
        }
        return p;
    }
    @Override
    public boolean existeId(int id){
        boolean existe = false;
        for (Personaje perso : this.listaPersonajes) {
            if (perso.getIdPer() == id){
                existe = true;
            }
        }
        return existe;
    }
}
