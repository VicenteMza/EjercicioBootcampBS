package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class RepositorioGenerosImpl implements IRepositorioGeneros{
    List<Genero> listaGeneros;
    public RepositorioGenerosImpl() {
        this.listaGeneros = new ArrayList<>(
                Arrays.asList(
                        new Genero(1, "Accion", new Pelicula()),
                        new Genero(2, "Accion", new Pelicula()),
                        new Genero(3, "Comedia", new Pelicula()),
                        new Genero(4, "Romance", new Pelicula()),
                        new Genero(5, "Drama", new Pelicula()),
                        new Genero(6, "Terror", new Pelicula())
                        )
        );
    }
    @Override
    public List<Genero> mostrarListaDeGeneros() {
        return this.listaGeneros;
    }

    @Override
    public Genero agregarGenero(Genero genero) {
        genero.setIdGen(listaGeneros.size()+1);
        listaGeneros.add(genero);
        System.out.println("Tamaño de la lista: " + listaGeneros.size());
        return genero;
    }
    @Override
    public Genero actulizarNombreGeneroPorId(int id, Genero genero) {
        for (Genero gen: listaGeneros) {
            if (gen.getIdGen() == id){
                gen.setNombre(genero.getNombre());
                break;
            }
        }
        return genero;
    }
    @Override
    public List<Pelicula> mostrarPeliculaPorGenero(String genero) {
        List<Pelicula> peli= new ArrayList<>();
        String gen = genero.toLowerCase().trim();

        for (Genero g : listaGeneros) {
            if (g.getNombre().toLowerCase().contains(gen)){
                peli.add(g.getPelicula());
            }
        }
        return peli;
    }
    @Override
    public boolean noExisteNombreDeGenero(String nombre) {
        return listaGeneros.stream()
                            .filter(gen -> gen.getNombre().toLowerCase().equals(nombre.trim()))
                            .findAny()
                            .isEmpty();
    }

    public boolean noExisteElID(int id){
        return listaGeneros.stream()
                            .filter(genId -> genId.getIdGen() == id)
                            .findAny()
                            .isEmpty();
    }
}
