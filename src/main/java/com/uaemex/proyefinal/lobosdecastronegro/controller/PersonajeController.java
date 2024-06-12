package com.uaemex.proyefinal.lobosdecastronegro.controller;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import com.uaemex.proyefinal.lobosdecastronegro.service.PersonajeService;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.PersonajeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Personajes")
public class PersonajeController {
    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    //Permite crear elementos
    @PostMapping
    public Personaje crearPersonaje(@RequestBody PersonajeDTO personajeDTO){
        return this.personajeService.creaPersonaje(personajeDTO);
    }

    @GetMapping
    public List<Personaje> findAll (){
        return this.personajeService.findAll();
    }

    @PatchMapping("/actualizarRol/{id_personaje}")
    public ResponseEntity<Void> actualizarEstado (@PathVariable("id_personaje") Integer id_personaje){
        this.personajeService.actualizarRol(id_personaje);
        return ResponseEntity.noContent().build();
    }

    //Eliminar por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersonaje(@PathVariable Integer id) {
        personajeService.eliminarPersonaje(id);
        return ResponseEntity.noContent().build();
    }

}
