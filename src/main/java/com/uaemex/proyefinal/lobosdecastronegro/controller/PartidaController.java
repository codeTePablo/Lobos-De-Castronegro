package com.uaemex.proyefinal.lobosdecastronegro.controller;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Partida;
import com.uaemex.proyefinal.lobosdecastronegro.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @PostMapping
    public Partida crearPartida(@RequestBody Partida partida) {
        return partidaService.crearPartida(partida);
    }

    @PutMapping("/{partidaId}/jugadores")
    public Partida agregarJugadores(@PathVariable int partidaId, @RequestBody List<Integer> jugadoresIds) {
        return partidaService.agregarJugadores(partidaId, jugadoresIds);
    }
}
