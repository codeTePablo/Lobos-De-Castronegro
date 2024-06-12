package com.uaemex.proyefinal.lobosdecastronegro.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Table(name ="personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_personaje;
    private String rol;
    private String descripcion;

    public Personaje() {
    }

    public Personaje(int id_personaje, String rol, String descripcion) {
        this.id_personaje = id_personaje;
        this.rol = rol;
        this.descripcion = descripcion;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
