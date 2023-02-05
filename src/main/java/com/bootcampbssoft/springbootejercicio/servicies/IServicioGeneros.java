package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;

import java.util.List;

public interface IServicioGeneros {
    public List<Genero> mostrarListaDeGeneros();
    public Genero agregarGenero(Genero genero);
    public Genero actulizarGeneroPorId(int id, Genero genero);


}
