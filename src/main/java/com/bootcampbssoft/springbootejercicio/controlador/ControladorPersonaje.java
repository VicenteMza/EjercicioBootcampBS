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

            if (personajes == null){
                mensajeBody.put("success", Boolean.FALSE);
                mensajeBody.put("message", "La edad no puede ser menor a Cero.");

                return ResponseEntity.badRequest().body(mensajeBody);
            }

            if (personajes.isEmpty()){
                mensajeBody.put("message", "No se encontro la busqueda del id: " + edad);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeBody);
            }

        /*return ResponseEntity.ok().body(personajes);*/
        return ResponseEntity.status(HttpStatus.OK).body(personajes);
    }
    @GetMapping("/edad/")
    public ResponseEntity<?> mostrarPersonajePorRangoDeEdad(
                                            @RequestParam int desde,
                                            @RequestParam int hasta) {
        List<Personaje> lpersonas = iSpersonaje.mostrarPersonajePorRangoDeEdad(desde, hasta);
        Map<String, Object> mensajeBody = new HashMap();

        if (lpersonas == null){
            mensajeBody.put("mensaje", ("Error en el ingreso de las edades"));
            return ResponseEntity.badRequest().body(mensajeBody);
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
        System.out.println("Id: "+ id + "\nPersonaje: " + personaje);
        Personaje per = iSpersonaje.actualizarPersonajePorID(id, personaje);
        Map<String, Object> mensajeBody = new HashMap<>();

        if (per == null){
            mensajeBody.put("message", "Error en el ingresos del ID");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        return ResponseEntity.ok().body(per);
    }
}
