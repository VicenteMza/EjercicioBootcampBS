package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicioGenerosImpl implements IServicioGeneros{
    @Autowired
    private IRepositorioGeneros iRepoGeneros;
    @Override
    public Genero agregarGenero(Genero genero) {
        String nombre = genero.getNombre().toUpperCase().trim();
        genero.setNombre(nombre);

        Optional<Genero> oGenero = this.iRepoGeneros.buscarPorNombre(genero.getNombre());

        if(oGenero.isPresent()){
                throw new RuntimeException("Genero existente");
        }
        return this.iRepoGeneros.save(genero);
    }
    @Override
    public List<Genero> mostrarListaDeGeneros() {
        return this.iRepoGeneros.findAll();
    }

    @Override
    public Genero actulizarGeneroPorId(int id, Genero genero) {
            Genero gen = null;
        Optional<Genero> nomExiste = this.iRepoGeneros.buscarPorNombre(genero.getNombre().toUpperCase().trim());

        try{
            //Si el ID no existe error: NoSuchElementException, devuelve un null
            Optional<Genero> idExiste = this.iRepoGeneros.findById(id);

            if(nomExiste.isPresent()){
                throw new RuntimeException("Genero existente");
            }

            gen = idExiste.get();

                gen.setNombre(genero.getNombre().toUpperCase().trim());

                gen = this.iRepoGeneros.save(gen);

        }catch (NoSuchElementException e){
            System.out.println("Id no exite! \n" + e);
        }
        return gen;
    }
}
