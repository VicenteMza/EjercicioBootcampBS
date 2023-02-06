package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import com.bootcampbssoft.springbootejercicio.repositories.IRepositorioPersonajes;
import com.bootcampbssoft.springbootejercicio.servicies.IServicioPersonajes;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personajes")
public class ControladorPersonaje {
    @Autowired
    private IServicioPersonajes iSpersonaje;
    @GetMapping("/")
    public ResponseEntity<List<Personaje>> mostrarTodosLosPersonajes(){
        List<Personaje> personajes = iSpersonaje.mostrarTodosLosPersonajes();

        if (personajes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personajes);
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<?> buscarPersonajePorNombre(@PathVariable String nombre){
        List<Personaje> pers = iSpersonaje.buscarPorNombre(nombre);
        if (pers.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pers);
    }
    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> buscarPersonajePorEdad(@PathVariable int edad){
        Map<String, Object> mensajeBody = new HashMap<>();
        List<Personaje> personajes = iSpersonaje.buscarPorEdad(edad);
        if (edad < 0){
            mensajeBody.put("message", "La edad no puede ser negativa.");

            return ResponseEntity.badRequest().body(mensajeBody);
        }

        if (personajes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /*return ResponseEntity.ok().body(personajes);*/
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }
    @GetMapping("/edad/")
    public ResponseEntity<?> mostrarPersonajePorRangoDeEdad(
                                                        @RequestParam int desde,
                                                        @RequestParam int hasta) {
        Map<String, Object> mensajeBody = new HashMap();
        if (desde > hasta && desde > 0 ){
            mensajeBody.put("mensaje", ("Error en el ingreso de las edades"));
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        List<Personaje> lpersonas = iSpersonaje.mostrarPersonajePorRangoDeEdad(desde, hasta);

        if (lpersonas == null){

        }
        if (lpersonas.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(lpersonas);
    }

    @PostMapping("/")
    public ResponseEntity<?> agregarPersonaje(@RequestBody Personaje personaje){
        Personaje perso = iSpersonaje.agregarPersonaje(personaje);
        return ResponseEntity.ok().body(perso);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonajePorID(@PathVariable int id,
                                              @RequestBody Personaje personaje){
        Map<String, Object> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "El id:"+id+" ,no puede ser negativo");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        Personaje per = iSpersonaje.actualizarPersonajePorID(id, personaje);

        if (per == null){
            mensajeBody.put("message", "Error en el ingresos del ID");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        return ResponseEntity.ok().body(per);
    }
}
