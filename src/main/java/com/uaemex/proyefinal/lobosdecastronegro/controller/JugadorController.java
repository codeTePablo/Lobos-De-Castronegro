package com.uaemex.proyefinal.lobosdecastronegro.controller;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import com.uaemex.proyefinal.lobosdecastronegro.service.JugadorService;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.JugadorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    //Solo se comunica con la capa de servicio
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    //Permite crear elementos
    @PostMapping
    public Jugador crearJugador(@RequestBody JugadorDTO jugadorDTO){
        return this.jugadorService.creaJugador(jugadorDTO);
    }

    //Los lleva para que voten
    @GetMapping
    public List<Jugador> findAll (){
        return this.jugadorService.findAll();
    }

    //Trae a los usuarios que aun no han sido eliminados
    @GetMapping("/noeliminados")
    public List<Jugador> eliminadosFalse() {
        return this.jugadorService.sobrevivientes();
    }

    //Ahora aquí se van actualizar en la base de datos los jugadores que
    //por votación murieron
    @PatchMapping("/actualizarEstado/{id_jugador}")
    public ResponseEntity<Void> actualizarEstado (@PathVariable("id_jugador") Integer id_jugador){
        this.jugadorService.actualizarEstado(id_jugador);
        return ResponseEntity.noContent().build();
    }

    //Eliminar por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Integer id) {
        jugadorService.eliminarJugador(id);
        return ResponseEntity.noContent().build();
    }

    //Eliminar por elimado=true
    @DeleteMapping("/eliminar/eliminados")
    public ResponseEntity<Void> eliminarJugadoresEliminados() {
        jugadorService.eliminarJugadoresEliminados();
        return ResponseEntity.noContent().build();
    }

}
