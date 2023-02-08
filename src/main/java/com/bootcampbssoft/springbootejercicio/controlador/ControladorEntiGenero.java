package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Genero;
import com.bootcampbssoft.springbootejercicio.servicies.IServicioEntiGeneros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/EntiGenero")
public class ControladorEntiGenero {
    @Autowired
    IServicioEntiGeneros iServicioEntiGeneros;
    @PostMapping("/")
    public ResponseEntity<?> AgregarGenero(@RequestBody Genero genero){
        Genero gen = iServicioEntiGeneros.agregarGenero(genero);
        return ResponseEntity.ok(gen);
    }
}
