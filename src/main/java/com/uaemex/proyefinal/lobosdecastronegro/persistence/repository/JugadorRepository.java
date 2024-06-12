package com.uaemex.proyefinal.lobosdecastronegro.persistence.repository;

import com.uaemex.proyefinal.lobosdecastronegro.persistence.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    //Función de repositorio

    //Llama a los que aún no han sido eliminados
    @Query("SELECT j FROM Jugador j WHERE j.eliminado = false")
    List<Jugador> findByEliminadoFalse();

    @Modifying
    @Query(value="Update jugador SET eliminado=true WHERE id_jugador=:id_jugador", nativeQuery = true)
    public void actualizarEstado (@Param("id_jugador") Integer id_jugador);

    //Para eliminar a los jugadores por id
    @Modifying
    @Transactional
    @Query("DELETE FROM Jugador j WHERE j.id_jugador =:id_jugador")
    void eliminarJugador();

    //Para eliminar a los jugadores que tnegan en el campo eliminados=true
    @Modifying
    @Transactional
    @Query("DELETE FROM Jugador j WHERE j.eliminado =true")
    void deleteByEliminadoTrue();

}
