package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import com.bootcampbssoft.springbootejercicio.servicies.IServiceCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class ControllerCharacter {
    @Autowired
    private IServiceCharacter iCharacterService;

    @PostMapping("/")
    public ResponseEntity<?> createCharacter(@RequestBody Character character){
        Character perso = this.iCharacterService.createCharacter(character);

        return ResponseEntity.status(HttpStatus.CREATED).body(perso);
    }

    @GetMapping("/")
    public ResponseEntity<List<Character>> showAllCharacters(){
        List<Character> character = this.iCharacterService.showAllCharacters();

        if (character.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        System.out.println(character);
        return ResponseEntity.ok().body(character);
    }
    /*


    @GetMapping("/{nombre}")
    public ResponseEntity<?> buscarPersonajePorNombre(@PathVariable String nombre){
        List<Character> pers = iSpersonaje.buscarPorNombre(nombre);
        if (pers.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pers);
    }
    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> buscarPersonajePorEdad(@PathVariable int edad){
        Map<String, Object> mensajeBody = new HashMap<>();
        List<Character> personajes = iSpersonaje.buscarPorEdad(edad);
        if (edad < 0){
            mensajeBody.put("message", "La edad no puede ser negativa.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        if (personajes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /*return ResponseEntity.ok().body(personajes);*/
      //  return ResponseEntity.status(HttpStatus.OK).body(personajes);
    //}
    /*
    @GetMapping("/edad/")
    public ResponseEntity<?> mostrarPersonajePorRangoDeEdad(
                                                        @RequestParam int desde,
                                                        @RequestParam int hasta) {
        Map<String, Object> mensajeBody = new HashMap();

        if (desde > hasta && desde > 0 ){
            mensajeBody.put("mensaje", ("Error en el ingreso de las edades"));
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        List<Character> lpersonas = iSpersonaje.mostrarPersonajePorRangoDeEdad(desde, hasta);

        if (lpersonas.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(lpersonas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonajePorID(@PathVariable int id,
                                              @RequestBody Character personaje){
        Map<String, Object> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "El id: "+id+" ,no puede ser negativo");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        Character per = iSpersonaje.actualizarPersonajePorID(id, personaje);

        if (per == null){
            mensajeBody.put("message", "El id: "+id+ " no existe.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        return ResponseEntity.ok().body(per);
    }

     */
}
