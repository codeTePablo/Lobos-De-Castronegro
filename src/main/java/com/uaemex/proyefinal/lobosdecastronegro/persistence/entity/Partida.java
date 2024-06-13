package com.uaemex.proyefinal.lobosdecastronegro.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name ="partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_partida;
    // esado (activa o terminada)
    private String horario;
    private boolean enCurso;
    private int rondaActual;

    @ElementCollection
    private List<Integer> jugadoresIds;
}
