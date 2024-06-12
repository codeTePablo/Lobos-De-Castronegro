package com.uaemex.proyefinal.lobosdecastronegro.mapper;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.JugadorDTO;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JugadorDTOtoJugador implements IMapper<JugadorDTO, Jugador> {

    @Override
    public Jugador map(JugadorDTO in) {
        Jugador jugador = new Jugador();
        jugador.setNombre(in.getNombre());
        jugador.setId_partida(in.getId_partida());
        return jugador;
    }
}
