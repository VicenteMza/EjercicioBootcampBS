package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServicioGenerosImpl implements IServicioGeneros{
    @Autowired
    private IRepositorioGeneros iRepositorioGeneros;
    @Override
    public Genero agregarGenero(Genero genero) {
        genero.setNombre(genero.getNombre().toUpperCase().trim());

        if (this.iRepositorioGeneros.findByName(genero.getNombre()).isPresent()){
            return null;
        }
        return this.iRepositorioGeneros.save(genero);
    }

    @Override
    public List<Genero> mostrarListaDeGeneros() {

        return this.iRepositorioGeneros.findAll();
    }

    @Override
    public Genero actulizarGeneroPorId(int id, Genero genero) {
        Genero gen = null;
        genero.setNombre(genero.getNombre().toUpperCase().trim());

        if(nombreExiste(genero.getNombre()).isPresent()){
            throw new RuntimeException("Nombre :"+genero.getNombre()+" Genero existente");
        }

        try{
            //Si el ID no existe error: NoSuchElementException, devuelve un null
            Optional<Genero> idExiste = this.iRepositorioGeneros.findById(id);

            gen = idExiste.get();

            gen.setNombre(genero.getNombre().toUpperCase().trim());

            gen = this.iRepositorioGeneros.save(gen);

        }catch (NoSuchElementException e){
            System.out.println("Id: "+ id +", no exite\n" +e);
        }
        return gen;
    }

    private Optional<Genero> nombreExiste (String nombre){
        return this.iRepositorioGeneros.findByName(nombre);
    }
}
