package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;
import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorPersonaje {

    private ListasUtilidades lUtilidades = new ListasUtilidades();
@GetMapping("/personajes/{nombre}")
    public List<Personaje> buscarPersonajePorNombre(@PathVariable String nombre){
        return lUtilidades.buscarPorNombre(nombre);
    }

    @GetMapping("/personajes")
    public List<Personaje> mostrarPersonajes(){
         return lUtilidades.listarPersonajes();
    }

    @GetMapping("/personajes/edad/{edad}")
    public List<Personaje> buscarPersonajePorEdad(@PathVariable String edad){
        return lUtilidades.buscarPorEdad(edad);
    }

    @GetMapping("/peliculas")
    public List<Pelicula> mostrarPeliculas(){
    return lUtilidades.mostrarTodasLasPeliculas();
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> mostrarPeliculaPorTitulo(@PathVariable String titulo){

        return lUtilidades.mostrarTodasLasPeliculaPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> mostrarPeliculaPorGenero(@PathVariable String genero){

        return lUtilidades.mostrarPeliculaPorGenero(genero);
    }
}
