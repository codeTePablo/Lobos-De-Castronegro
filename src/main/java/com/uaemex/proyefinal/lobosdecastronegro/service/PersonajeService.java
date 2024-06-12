package com.uaemex.proyefinal.lobosdecastronegro.service;

import com.uaemex.proyefinal.lobosdecastronegro.exceptions.ToDoExceptions;
import com.uaemex.proyefinal.lobosdecastronegro.mapper.PersonajeDTOtoPersonaje;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import com.uaemex.proyefinal.lobosdecastronegro.persistence.repository.PersonajeRepository;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.PersonajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    //Implementar toda la lógica de negocio
    //Inyección de dependencias
    private final PersonajeRepository repository;
    private final PersonajeDTOtoPersonaje mapper;

    public PersonajeService(PersonajeRepository repository, PersonajeDTOtoPersonaje mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Personaje creaPersonaje(PersonajeDTO personajeDTO ) {
        Personaje personaje = mapper.map(personajeDTO);
        personaje.setRol(personaje.getRol());
        personaje.setDescripcion(personaje.getDescripcion());
        return  this.repository.save(personaje);
    }

    public Personaje retornaInt(PersonajeDTO personajeDTO){
        return null;
    }

    public List<Personaje> findAll(){
        return this.repository.findAll();
    }

    @Transactional
    public void actualizarRol(Integer idPersonaje) {
        Optional<Personaje> optionalPersonaje = this.repository.findById(idPersonaje);
        if (optionalPersonaje.isEmpty()) {
            throw new ToDoExceptions("Jugador no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.actualizarRol(idPersonaje);
    }

    //Eliminar a un personaje por ID
    @Transactional
    public void eliminarPersonaje(Integer id) {
        Optional<Personaje> optionalPersonaje = this.repository.findById(id);
        if (optionalPersonaje.isEmpty()) {
            throw new ToDoExceptions("Personaje no encontrado", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
