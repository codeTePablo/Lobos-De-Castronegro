package com.uaemex.proyefinal.lobosdecastronegro.persistence.repository;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonajeDataLoader implements CommandLineRunner {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verifica si los personajes ya existen para evitar duplicados
        if (personajeRepository.count() == 0) {
            // Crea y guarda personajes
            personajeRepository.save(new Personaje(1, "Lobo", "Un lobo feroz"));
            personajeRepository.save(new Personaje(2, "Aldeano", "Un simple aldeano"));
            personajeRepository.save(new Personaje(3, "Vidente", "Puede ver la identidad de otros jugadores"));
            personajeRepository.save(new Personaje(4, "Cazador", "Puede disparar a un jugador si muere"));
        }
    }
}
