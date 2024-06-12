package com.uaemex.proyefinal.lobosdecastronegro.mapper;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import com.uaemex.proyefinal.lobosdecastronegro.service.dto.PersonajeDTO;

import org.springframework.stereotype.Component;

@Component
public class PersonajeDTOtoPersonaje implements IMapper<PersonajeDTO, Personaje> {

    @Override
    public Personaje map(PersonajeDTO in) {
        Personaje personaje = new Personaje();
        personaje.setRol(in.getRol());
        personaje.setDescripcion(in.getDescripcion());
        return personaje;
    }
}
