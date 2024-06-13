package com.uaemex.proyefinal.lobosdecastronegro.service;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Partida;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {
    @Autowired
    private PartidaRepository partidaRepository;

    public Partida crearPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida agregarJugadores(int partidaId, List<Integer> jugadoresIds) {
        Partida partida = partidaRepository.findById(partidaId)
                .orElseThrow(() -> new RuntimeException("Partida no encontrada"));

        partida.setJugadoresIds(jugadoresIds);
        return partidaRepository.save(partida);
    }
}
