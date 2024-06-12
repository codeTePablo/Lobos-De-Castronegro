package com.uaemex.proyefinal.lobosdecastronegro.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_jugador;
    private String nombre;
    private int id_partida;
    private int id_personaje;
    private boolean eliminado;
    private String rol;
    private String descripcion;
}
