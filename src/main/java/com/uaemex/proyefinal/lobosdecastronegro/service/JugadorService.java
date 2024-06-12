package com.uaemex.proyefinal.lobosdecastronegro.service;

import com.uaemex.proyefinal.lobosdecastronegro.exceptions.ToDoExceptions;
import com.uaemex.proyefinal.lobosdecastronegro.mapper.JugadorDTOtoJugador;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.repository.JugadorRepository;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.repository.PersonajeRepository;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.JugadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class JugadorService {
    //Implementar toda la lógica de negocio
    //Inyección de dependencias
    private final JugadorRepository repository;
    private final JugadorDTOtoJugador mapper;

    public JugadorService(JugadorRepository repository, JugadorDTOtoJugador mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Autowired
    private PersonajeRepository personajeRepository;

    //Usuario ingresa parametros para jugar
    public Jugador creaJugador(JugadorDTO jugadorDto){
        Jugador jugador = mapper.map(jugadorDto);

        Random random = new Random();
        int randomIdPersonaje = random.nextInt(3) + 1;
        Personaje personaje = personajeRepository.findById(randomIdPersonaje).orElseThrow(() -> new RuntimeException("Personaje no encontrado"));
        jugador.setId_personaje(randomIdPersonaje);
        personaje.setId_personaje(jugador.getId_personaje());
        jugador.setRol(personaje.getRol());
        jugador.setDescripcion(personaje.getDescripcion());

        return  this.repository.save(jugador);
    }

    //Se llaman a todos los usuarios para votaciones
    public List<Jugador> findAll(){
        return this.repository.findAll();
    }

    //Llamar a los usuarios no eliminados
    public List<Jugador> sobrevivientes() {
        return this.repository.findByEliminadoFalse();
    }

    @Transactional
    public void actualizarEstado (Integer id_jugador){
        Optional<Jugador> optionalJugador = this.repository.findById(id_jugador);
        if (optionalJugador.isEmpty()) {
            throw new ToDoExceptions("Jugador no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.actualizarEstado(id_jugador);
    }

    //Eliminar a un jugador por ID
    @Transactional
    public void eliminarJugador(Integer id) {
        Optional<Jugador> optionalJugador = this.repository.findById(id);
        if (optionalJugador.isEmpty()) {
            throw new ToDoExceptions("Jugador no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

    //Eliminar a un jugador por eliminado=true
    @Transactional
    public void eliminarJugadoresEliminados() {
        this.repository.deleteByEliminadoTrue();
    }

}
