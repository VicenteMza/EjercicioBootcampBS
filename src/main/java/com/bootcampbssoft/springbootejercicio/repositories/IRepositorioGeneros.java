package com.bootcampbssoft.springbootejercicio.repositories;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;

import java.util.List;

public interface IRepositorioGeneros {
    public List<Pelicula> mostrarPeliculaPorGenero(String genero);
    public Genero agregarGenero(Genero genero);
    public Genero actulizarNombreGeneroPorId(int id, Genero genero);
    public List<Genero> mostrarListaDeGeneros();
    public boolean noExisteNombreDeGenero(String nombre);
    public boolean noExisteElID(int id);
}
