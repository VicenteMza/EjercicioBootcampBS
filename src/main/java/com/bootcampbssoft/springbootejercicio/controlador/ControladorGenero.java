package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.servicies.IServicioGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generos")
public class ControladorGenero {
    @Autowired
    IServicioGeneros iServicioGeneros;

    @PostMapping("/")
    public ResponseEntity<?> agregarGenero(@RequestBody Genero genero){

        Genero gen = this.iServicioGeneros.agregarGenero(genero);

        return ResponseEntity.status(HttpStatus.CREATED).body(gen);
    }

    @GetMapping("/")
    public ResponseEntity<?> mostrarListaDeGeneros (){
        List<Genero> gens = this.iServicioGeneros.mostrarListaDeGeneros();
        if (gens.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(gens);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actulizarGeneroPorId (@PathVariable int id,
                                       @RequestBody Genero genero) {
        Map<String, String> mensajeBody = new HashMap<>();

        if (id < 0) {
            mensajeBody.put("message", "Id: " + id + " , no puede ser menor a cero");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        Genero gen = this.iServicioGeneros.actulizarGeneroPorId(id, genero);

        if (gen == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(gen);
    }
}
