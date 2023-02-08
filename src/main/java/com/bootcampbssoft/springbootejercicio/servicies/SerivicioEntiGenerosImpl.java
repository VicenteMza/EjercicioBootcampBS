package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioEntiGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SerivicioEntiGenerosImpl implements IServicioEntiGeneros{
    @Autowired
    private IRepositorioEntiGeneros iRepositorioEntiGeneros;

    @Override
    public com.bootcampbssoft.springbootejercicio.entidades.Genero agregarGenero(com.bootcampbssoft.springbootejercicio.entidades.Genero genero) {
        return iRepositorioEntiGeneros.save(genero);
    }

    @Override
    public Genero actulizarGeneroPorId(int id, Genero genero) {
        return null;
    }

    @Override
    public List<Genero> mostrarListaDeGeneros() {
        return null;
    }
}
