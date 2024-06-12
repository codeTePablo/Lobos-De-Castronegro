package com.uaemex.proyefinal.lobosdecastronegro.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_partida;
    // estado (activa o terminada)

    private String horario;
}
