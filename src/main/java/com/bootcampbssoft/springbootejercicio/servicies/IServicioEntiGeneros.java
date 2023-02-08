package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;

import java.util.List;

public interface IServicioEntiGeneros {
    public com.bootcampbssoft.springbootejercicio.entidades.Genero agregarGenero(com.bootcampbssoft.springbootejercicio.entidades.Genero genero);
    public Genero actulizarGeneroPorId(int id, Genero genero);
    public List<Genero> mostrarListaDeGeneros();

}
