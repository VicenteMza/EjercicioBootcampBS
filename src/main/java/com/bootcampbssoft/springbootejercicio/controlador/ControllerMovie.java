package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import com.bootcampbssoft.springbootejercicio.servicies.IServiceMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class ControllerMovie {
    @Autowired
    private IServiceMovie iMovieService;

    @PostMapping("/")
    public ResponseEntity<?> createMovie(@RequestBody Movie movie){

        Movie peli = this.iMovieService.createMovie(movie);
        if (peli == null){
            return ResponseEntity.badRequest().build();
        }
            return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping("/")
    public ResponseEntity<?> showAllMovies(){
        List<Movie> pelis = iMovieService.showAllMovies();

        if (pelis.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
            return ResponseEntity.ok().body(pelis);
    }
    /*



    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<?> mostrarTodasLasPeliculaPorTitulo(@PathVariable String titulo){
        List<Movie> peli = this.iServicioPeliculas.mostrarTodasLasPeliculaPorTitulo(titulo);

        if (peli.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(peli);
    }
/*
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Movie>> mostrarPeliculaPorGenero(@PathVariable String genero){
        List<Movie> lPelis = this.iServicioPeliculas.mostrarPeliculaPorGenero(genero);

        if (lPelis.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lPelis);
    }*/

/*
    @GetMapping("/fechas/")
    public ResponseEntity<?> mostrarPeliculaPorRangoDeFecha(
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta) {
        Map<String, String> mensajeBody = new HashMap<>();
        List<Movie> pelis = this.iServicioPeliculas.mostrarPeliculaPorRangoDeFecha(desde, hasta);

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
    /*
        List<Movie> pelis = this.iServicioPeliculas.mostrarPeliculaPorRangoCalificacion(desde, hasta);
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


    }*/
    /*
    @PostMapping("/")
    public ResponseEntity<?> agregarPelicula(@RequestBody Movie pelicula){
        Movie peli = this.iServicioPeliculas.agregarPelicula(pelicula);
        if (peli == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarPelicula(@PathVariable int id,
                             @RequestBody Movie pelicula){
        Map<String, String> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "Id: "+id+",no puede ser negativo.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        Movie peli = this.iServicioPeliculas.actualizarPelicula(id, pelicula);

        if (peli == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(peli);
    }
    */
}
