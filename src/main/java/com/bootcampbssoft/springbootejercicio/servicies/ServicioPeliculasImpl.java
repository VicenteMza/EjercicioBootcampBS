package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import com.bootcampbssoft.springbootejercicio.entidades.Personaje;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPeliculasImpl implements IServicioPeliculas{
    @Autowired
    private IRepositorioPeliculas iRepositorioPeliculas;

    @Override
    public Pelicula agregarPelicula(Pelicula pelicula) {
        pelicula.setTitulo(pelicula.getTitulo().toUpperCase().trim());

        if (existePelicula(pelicula.getTitulo(), pelicula.getFecha())){
            throw new RuntimeException("Titulo: "+pelicula.getTitulo()+ ", Fecha: "+pelicula.getFecha() +" existente!");
        }
        Pelicula p = this.iRepositorioPeliculas.save(pelicula);
        //List<Personaje> lperso = pelicula.getPersonajes();

        //for (Personaje personaje : lperso) {
        //    this.iRepositorioPeliculas.savePersoPeli(p.getIdPeli(), personaje.getIdPer());
        //}
        return pelicula;
    }

    @Override
    public List<Pelicula> mostrarTodasLasPeliculas() {
        return this.iRepositorioPeliculas.findAll();
    }

    private boolean existePelicula(String titulo, LocalDate fecha){
        boolean existe = false;
        Optional<Pelicula> peli = this.iRepositorioPeliculas.findByTitle(titulo);

         if (peli.isPresent()){
             LocalDate fechaPeli = peli.get().getFecha();
             existe = fecha.isEqual(fechaPeli);
             return existe;
         }
        System.out.println("Existe titulo: " + existe);
        return existe;
    }

    /*




    @Override
    public List<Pelicula> mostrarTodasLasPeliculaPorTitulo(String titulo) {
        return this.repoPelicula.mostrarTodasLasPeliculaPorTitulo(titulo);
    }

    @Override
    public List<Pelicula> mostrarPeliculaPorRangoDeFecha(LocalDate desde, LocalDate hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoDeFecha(desde, hasta);
    }

    @Override
    public List<Pelicula> mostrarPeliculaPorRangoCalificacion(int desde, int hasta) {
        return this.repoPelicula.mostrarPeliculaPorRangoCalificacion(desde,hasta);
    }



    @Override
    public Pelicula actualizarPelicula(int id, Pelicula pelicula) {
        System.out.println(!this.repoPelicula.idExiste(id));
        System.out.println(this.repoPelicula.peliculaRepetida(pelicula));
        System.out.println("-----------------------------");

        if(!this.repoPelicula.idExiste(id) || this.repoPelicula.peliculaRepetida(pelicula)){
            return null;
        }
        return this.repoPelicula.actualizarPelicula(id, pelicula);
    }
    */
}
