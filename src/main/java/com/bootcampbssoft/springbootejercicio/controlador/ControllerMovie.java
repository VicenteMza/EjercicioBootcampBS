package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Movie;
import com.bootcampbssoft.springbootejercicio.servicies.IServiceMovie;
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

    @GetMapping("/titulo/{title}")
    public ResponseEntity<?> showMoviesByTitle(@PathVariable String title){
        Map<String, String> mensajeBody = new HashMap<>();
        List<Movie> peli = this.iMovieService.showMoviesByTitle(title);

        if (peli.isEmpty()){
            mensajeBody.put("message", "No se econtro resultasdo para la busqueda");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        return ResponseEntity.ok().body(peli);
    }

    @GetMapping("/fechas/")
    public ResponseEntity<?> showMovieByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate desde,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hasta) {
        Map<String, String> mensajeBody = new HashMap<>();
        System.out.println("comparacion de fechas: "+desde.isAfter(hasta));

        if (desde.isAfter(hasta)){
            mensajeBody.put("message", "Invertir el orden de las fechas ingresadas.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        List<Movie> pelis = this.iMovieService.showMovieByDateRange(desde, hasta);

        if (pelis.isEmpty()){
            mensajeBody.put("message","No hay resultados para la busqueda.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        return ResponseEntity.ok().body(pelis);
    }

    @GetMapping("/calificacion/")
    public ResponseEntity<?> showMovieByRangeRating(
            @RequestParam int desde,
            @RequestParam int hasta) {
        Map<String, String> mensajeBody = new HashMap<>();
        if(desde >  hasta){
            mensajeBody.put("message", "Invertir el orden de las calificaciones.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        if (desde < 0 || hasta > 5){
            mensajeBody.put("message", "Las calificaiones estan fuera de rango.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        List<Movie> pelis = this.iMovieService.showMovieByRangeRating(desde, hasta);

        if (pelis.isEmpty()){
            mensajeBody.put("message","No hay resultados pra la busqueda");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        return ResponseEntity.ok().body(pelis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upDateMovie(@PathVariable int id,
                             @RequestBody Movie movie){
        Map<String, String> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "Id: "+id+",no puede ser negativo.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        Movie peli = this.iMovieService.upDateMovie(id, movie);

        if (peli == null){
            mensajeBody.put("message","id Desconocido");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        return ResponseEntity.ok().body(peli);
    }

}
