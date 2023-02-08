package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        String nombre = genero.getNombre().toUpperCase();
        genero.setNombre(nombre);

        Optional<Genero> oGenero = this.iRepoGeneros.buscarPorNombre(genero.getNombre());

        if(oGenero.isPresent()){
                throw new RuntimeException("Genero existente");
        }
        System.out.println(oGenero);
        return this.iRepoGeneros.save(genero);
    }
    /*
    @Override
    public Genero actulizarGeneroPorId(int id, Genero genero) {
        boolean nomExist = this.iRepoGeneros.existeNombreDeGenero(genero.getNombre().trim());
        boolean idExiste = this.iRepoGeneros.existeElId(id);
        
        //if ((idExiste && nomExist) || !idExiste){ //Condicion original
        if (!idExiste || nomExist){
            return null;
        }
        return this.iRepoGeneros.actulizarNombreGeneroPorId(id, genero);
    }
    @Override
    public List<Genero> mostrarListaDeGeneros() {

        return this.iRepoGeneros.mostrarListaDeGeneros();
    }
     */
}
