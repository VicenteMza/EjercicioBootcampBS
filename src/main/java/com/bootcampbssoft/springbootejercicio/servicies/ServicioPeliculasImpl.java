package com.bootcampbssoft.springbootejercicio.servicies;

import com.bootcampbssoft.springbootejercicio.entidades.Pelicula;
import com.bootcampbssoft.springbootejercicio.entidadesDTO.PeliculaDTO;
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
        System.out.println(pelicula);

        System.out.println("Titulo: "+pelicula.getTitulo().toUpperCase().trim());
        System.out.println("calificacion: "+pelicula.getCalificacion());
        System.out.println("fecha: "+pelicula.getFecha());
       // PeliculaDTO pelDTO = new PeliculaDTO(pelicula.getTitulo(),pelicula.getFecha(), pelicula.getCalificacion(), pelicula.getGenero().getId());
        //System.out.println(pelDTO);
        //System.out.println("id_genero: "+pelicula.getGenero().getId());
        /*
        Optional<Pelicula> oExisteNombre= this.repoPelicula.buscarPorNombre(pelicula.getTitulo());
        if (oExisteNombre.isEmpty()){
            return this.repoPelicula.save(pelicula);
        }
        LocalDate fechaPeliBD = oExisteNombre.get().getFecha();
        LocalDate fechaIngresada = pelicula.getFecha();

        if (oExisteNombre.isPresent() && fechaPeliBD.isEqual(fechaIngresada)){
            throw new RuntimeException("Pelicula existente");
        }

         */
        return this.iRepositorioPeliculas.save(pelicula);
    }

    @Override
    public List<Pelicula> mostrarTodasLasPeliculas() {
        return this.iRepositorioPeliculas.findAll();
    }

    /*


    @Override
    public List<Pelicula> mostrarTodasLasPeliculas() {
        return this.repoPelicula.mostrarTodasLasPeliculas();
    }

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
