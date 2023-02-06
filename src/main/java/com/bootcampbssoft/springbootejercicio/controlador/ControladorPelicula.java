package com.bootcampbssoft.springbootejercicio.controlador;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;

import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import com.bootcampbssoft.springbootejercicio.servicies.IServicioPeliculas;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/peliculas")
public class ControladorPelicula {
    @Autowired
    IServicioPeliculas iServicioPeliculas;
    @GetMapping("/")
    public ResponseEntity<?> mostrarTodasLasPeliculas(){
        List<Pelicula> pelis = iServicioPeliculas.mostrarTodasLasPeliculas();
        if (pelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pelis);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> mostrarTodasLasPeliculaPorTitulo(@PathVariable String titulo){
        List<Pelicula> peli = this.iServicioPeliculas.mostrarTodasLasPeliculaPorTitulo(titulo);

        if (peli.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(peli);
    }
/*
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Pelicula>> mostrarPeliculaPorGenero(@PathVariable String genero){
        List<Pelicula> lPelis = this.iServicioPeliculas.mostrarPeliculaPorGenero(genero);

        if (lPelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lPelis);
    }*/


    @GetMapping("/fechas/")
    public ResponseEntity<?> mostrarPeliculaPorRangoDeFecha(
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta) {
        Map<String, String> mensajeBody = new HashMap<>();
        List<Pelicula> pelis = this.iServicioPeliculas.mostrarPeliculaPorRangoDeFecha(desde, hasta);

        if (desde.isAfter(hasta)){
            mensajeBody.put("message", "Invertir el orden de las fechas ingresadas.");
            return ResponseEntity.badRequest().build();
        }

        if (pelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pelis);
    }

    @GetMapping("/calificacion/")
    public ResponseEntity<?> mostrarPeliculaPorRangoCalificacion(
                                            @RequestParam int desde,
                                            @RequestParam int hasta) {
        Map<String, String> mensajeBody = new HashMap<>();
        if(desde >  hasta){
            mensajeBody.put("message", "Invertir el orden de las calificaciones.");
            return ResponseEntity.badRequest().build();
        }
        /*
        //No me parece que se deba hacer!
        if (desde > hasta){
            int aux = 0;
            aux = desde;
            desde = hasta;
            hasta = aux;
        }*/
        List<Pelicula> pelis = this.iServicioPeliculas.mostrarPeliculaPorRangoCalificacion(desde, hasta);
        if (pelis == null){
            mensajeBody.put("message", "Las calificaiones estan fuera de rango.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        if (pelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(pelis);
    }
    /*
    @PostMapping("/")
    public Pelicula pelicula(@RequestBody Pelicula pelicula){
        System.out.println(pelicula);
        return lUtilidades.agregarPelicula(pelicula);

    }*/
    @PostMapping("/")
    public ResponseEntity<?> agregarPelicula(@RequestBody Pelicula pelicula){
        Pelicula peli = this.iServicioPeliculas.agregarPelicula(pelicula);
        if (peli == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarPelicula(@PathVariable int id,
                             @RequestBody Pelicula pelicula){
        Map<String, String> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "Id: "+id+",no puede ser negativo.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        Pelicula peli = this.iServicioPeliculas.actualizarPelicula(id, pelicula);

        if (peli == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(peli);
    }
}
