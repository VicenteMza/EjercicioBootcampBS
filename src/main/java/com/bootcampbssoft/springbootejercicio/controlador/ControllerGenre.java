package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Genre;
import com.bootcampbssoft.springbootejercicio.servicies.IServiceGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generos")
public class ControllerGenre {

    @Autowired
    IServiceGenre iGenreService;
    @PostMapping("/")
    public ResponseEntity<?> createGenre(@RequestBody Genre genre){
        Map<String,String> mensajeBody = new HashMap<>();
        Genre gen = this.iGenreService.createGenre(genre);
        if (gen == null){
            mensajeBody.put("message","El genero de pelicula: " + genre.getName() +", ya existe");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
           return ResponseEntity.status(HttpStatus.CREATED).body(gen);
    }

    @GetMapping("/")
    public ResponseEntity<?> genreList (){
        List<Genre> gens = this.iGenreService.genreList();
        if (gens.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
           return ResponseEntity.ok().body(gens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGenreById (@PathVariable int id,
                                                   @RequestBody Genre genre){
        Map<String,String> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message","Id: "+id+ " , no puede ser menor a cero");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        Genre gen = this.iGenreService.updateGenreById(id, genre);
        if (gen == null){
            mensajeBody.put("message","Id: "+id+ " desconocido"); //hace falta mandar estos mensajes
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        return ResponseEntity.ok().body(gen);
    }
}
