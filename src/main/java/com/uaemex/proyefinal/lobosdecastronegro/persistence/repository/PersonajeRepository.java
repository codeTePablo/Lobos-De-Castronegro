package com.uaemex.proyefinal.lobosdecastronegro.persistence.repository;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonajeRepository extends JpaRepository <Personaje, Integer> {

    @Modifying
    @Query(value="Update personaje SET rol= WHERE id_personaje=:id_personaje", nativeQuery = true)
    public void actualizarRol (@Param("id_personaje") Integer id_personaje);
}
