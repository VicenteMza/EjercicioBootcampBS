package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioGenerosImpl implements IServicioGeneros{
    @Autowired
    private IRepositorioGeneros iRepoGeneros;
    //Otra forma de Inyeccion de dependencia
    /*public ServicioGenerosImpl(IRepositorioGeneros iRepoGeneros) {
        this.iRepoGeneros = iRepoGeneros;
    }*/
    @Override
    public Genero agregarGenero(Genero genero) {
        if (!this.iRepoGeneros.noExisteNombreDeGenero(genero.getNombre().toLowerCase())){
            return null;
        }
        return this.iRepoGeneros.agregarGenero(genero);
    }
    @Override
    public Genero actulizarGeneroPorId(int id, Genero genero) {
        boolean nomExist = this.iRepoGeneros.noExisteNombreDeGenero(genero.getNombre().toLowerCase());

        if (!this.iRepoGeneros.noExisteElID(id)  || !nomExist || id < 0){
            return null;
        }
        return this.iRepoGeneros.actulizarNombreGeneroPorId(id, genero);
    }
    @Override
    public List<Genero> mostrarListaDeGeneros() {

        return this.iRepoGeneros.mostrarListaDeGeneros();
    }
}
