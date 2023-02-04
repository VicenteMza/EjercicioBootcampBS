package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.dominio.Genero;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generos")
public class ControladorGenero {
    ListasUtilidades lUtilidades = new ListasUtilidades();
    @GetMapping("/")
    public ResponseEntity<?> mostrarListaDeGeneros (){
        List<Genero> gens = lUtilidades.mostrarListaDeGeneros();
        if (gens.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(gens);
    }
    @PostMapping("/")
    public ResponseEntity<Genero> genero(@RequestBody Genero genero){
        System.out.println(genero);
        Genero gen = lUtilidades.agregarGeneroDePelicula(genero);
        return ResponseEntity.ok().body(gen);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> generoPorId (@PathVariable int id,
                                       @RequestBody Genero genero){
        Map<String,String> mensajeBody = new HashMap<>();
        Genero gen = lUtilidades.actulizarGeneroPorId(id, genero);
        if (gen == null){
            mensajeBody.put("message","Id: "+id+ " desconocido");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        return ResponseEntity.ok().body(gen);
    }
}
