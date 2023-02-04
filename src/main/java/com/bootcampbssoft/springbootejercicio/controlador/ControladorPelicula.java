package com.bootcampbssoft.springbootejercicio.controlador;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.bootcampbssoft.springbootejercicio.dominio.Pelicula;

import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
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
    ListasUtilidades lUtilidades = new ListasUtilidades();
    @GetMapping("/")
    public ResponseEntity<?> peliculas(){
        List<Pelicula> pelis = lUtilidades.mostrarTodasLasPeliculas();
        if (pelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pelis);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> peliculaPorTitulo(@PathVariable String titulo){
        List<Pelicula> peli = lUtilidades.mostrarTodasLasPeliculaPorTitulo(titulo);

        if (peli.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(peli);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Pelicula>> peliculaPorGenero(@PathVariable String genero){
        List<Pelicula> lPelis = lUtilidades.mostrarPeliculaPorGenero(genero);

        if (lPelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lPelis);
    }


    @GetMapping("/fechas/")
    public ResponseEntity<?> peliculaPorRangoDeFecha(
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta) {

        List<Pelicula> pelis = lUtilidades.mostrarPeliculaPorRangoDeFecha(desde, hasta);
        if (desde.isAfter(hasta)){
            return ResponseEntity.badRequest().build();
        }
        if (pelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pelis);
    }

    @GetMapping("/calificacion/")
    public ResponseEntity<?> peliculaPorRangoCalificacion(
                                            @RequestParam int desde,
                                            @RequestParam int hasta) {
        List<Pelicula> pelis;
        Map<String, String> mensajeBody = new HashMap<>();
        /*
        if (desde > hasta){
            int aux = 0;
            aux = desde;
            desde = hasta;
            hasta = aux;
        }*/

        if (desde >= 1 && hasta <=5){
            pelis = lUtilidades.mostrarPeliculaPorRangoCalificacion(desde, hasta);
        }else {
            mensajeBody.put("message", "Las calificaiones estan fuera de rango.");
            pelis= null;
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        if (desde >hasta){
            return ResponseEntity.badRequest().build();
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
    public ResponseEntity<Pelicula> pelicula(@RequestBody Pelicula pelicula){
        lUtilidades.agregarPelicula(pelicula);

        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> pelicula(@PathVariable int id,
                             @RequestBody Pelicula pelicula){
        System.out.println("Id: "+ id + "\nPelicula: "+ pelicula);
        Pelicula peli = lUtilidades.actualizarPelicula(id, pelicula);

        if (peli == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(peli);
    }
}
