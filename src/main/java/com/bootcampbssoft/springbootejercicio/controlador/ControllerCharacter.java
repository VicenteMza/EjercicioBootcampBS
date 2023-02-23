package com.bootcampbssoft.springbootejercicio.controlador;

import com.bootcampbssoft.springbootejercicio.entidades.Character;
import com.bootcampbssoft.springbootejercicio.servicies.IServiceCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personajes")
public class ControllerCharacter {
    @Autowired
    private IServiceCharacter iServiceCharacter;

    @PostMapping("/")
    public ResponseEntity<?> createCharacter(@RequestBody Character character){
        Character perso = this.iServiceCharacter.createCharacter(character);

        return ResponseEntity.status(HttpStatus.CREATED).body(perso);
    }

    @GetMapping("/")
    public ResponseEntity<List<Character>> showAllCharacters(){
        List<Character> character = this.iServiceCharacter.showAllCharacters();

        if (character.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        System.out.println(character);
        return ResponseEntity.ok().body(character);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> searchCharacterByName(@PathVariable String name){
        List<Character> pers = this.iServiceCharacter.searchCharacterByName(name);
        if (pers.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pers);
    }

    @GetMapping("/edad/{age}")
    public ResponseEntity<?> searchCharacterByAge(@PathVariable int age) {
        Map<String, Object> mensajeBody = new HashMap<>();

        if (age < 0) {
            mensajeBody.put("message", "La edad no puede ser negativa.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }

        List<Character> personajes = this.iServiceCharacter.searchCharacterByAge(age);


        if (personajes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/edad/")
    public ResponseEntity<?> showCharacterByAgeRange(
            @RequestParam int desde,
            @RequestParam int hasta) {
        Map<String, Object> mensajeBody = new HashMap();

        if (desde > hasta || desde < 0){
            mensajeBody.put("mensaje", ("Error en el ingreso de las edades"));
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        List<Character> lpersonas = this.iServiceCharacter.showCharacterByAgeRange(desde, hasta);

        if (lpersonas.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(lpersonas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCharacterByID(@PathVariable int id,
                                                      @RequestBody Character character){
        Map<String, Object> mensajeBody = new HashMap<>();

        if (id < 0){
            mensajeBody.put("message", "El id: "+id+" ,no puede ser negativo");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        Character per = this.iServiceCharacter.updateCharacterByID(id, character);

        if (per == null){
            mensajeBody.put("message", "El id: "+id+ " no existe.");
            return ResponseEntity.badRequest().body(mensajeBody);
        }
        return ResponseEntity.ok().body(per);
    }
}
