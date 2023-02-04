package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.dominio.Personaje;
import com.bootcampbssoft.springbootejercicio.utilidades.ListasUtilidades;
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
    private ListasUtilidades lUtilidades = new ListasUtilidades();
    @GetMapping("/")
    public ResponseEntity<List<Personaje>> personajes(){
        List<Personaje> personajes = lUtilidades.listarPersonajes();

        if (personajes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personajes);
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<?> personajePorNombre(@PathVariable String nombre){
        List<Personaje> pers = lUtilidades.buscarPorNombre(nombre);
        if (pers.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pers);
    }
    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> personajePorEdad(@PathVariable int edad){
        List<Personaje> personajes;
        Map<String, Object> mensajeBody = new HashMap<>();

            if (edad < 0){
                mensajeBody.put("success", Boolean.FALSE);
                mensajeBody.put("message", "La edad no puede ser menor a Cero.");

                return ResponseEntity.badRequest().body(mensajeBody);
            }

        personajes = lUtilidades.buscarPorEdad(edad);

            if (personajes.isEmpty()){
                mensajeBody.put("message", "No se encontro la busqueda.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeBody);
            }

        /*return ResponseEntity.ok().body(personajes);*/
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }
    @GetMapping("/edad/")
    public ResponseEntity<?> personajePorRangoDeEdad(
                                            @RequestParam int desde,
                                            @RequestParam int hasta) {
        List<Personaje> lpersonas = new ArrayList<>();
        Map<String, Object> mensajeBody = new HashMap();

        if (desde < 0 || hasta < 0 || desde > hasta){
            mensajeBody.put("success", Boolean.FALSE);
            mensajeBody.put("mensaje", ("Las edades no puden ser negativas"));
            return ResponseEntity.
                    badRequest().
                    body(mensajeBody);
        }
        System.out.println(desde + "\n " +hasta);
        lpersonas = lUtilidades.mostrarPersonajePorRangoDeEdad(desde, hasta);

        return ResponseEntity.status(HttpStatus.OK).body(lpersonas);
    }
    @PostMapping("/")
    public ResponseEntity<?> personaje(@RequestBody Personaje personaje){
        System.out.println(personaje);
        Personaje perso = lUtilidades.agregarPersonaje(personaje);

        return ResponseEntity.ok().body(perso);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> personajePorID(@PathVariable int id,
                                              @RequestBody Personaje personaje){
        System.out.println("Id: "+ id + "\nPersonaje: " + personaje);
        Personaje per = lUtilidades.actualizarPersonajePorID(id, personaje);
        Map<String, Object> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "La Id no puede ser negativo");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        if (per == null){
            mensajeBody.put("message", "No se encontro personaje con el Id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeBody);
        }
        return ResponseEntity.ok().body(per);
    }
}
