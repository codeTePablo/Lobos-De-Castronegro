package com.uaemex.proyefinal.lobosdecastronegro.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

//Cuando pase algo en nuestra aplicación se van a lanzar excepciones
@Data
public class ToDoExceptions extends RuntimeException {
    private String mensaje;
    private HttpStatus httpStatus;

    public ToDoExceptions(String mensaje, HttpStatus httpStatus) {
        super(mensaje);
        this.mensaje = mensaje;
        this.httpStatus = httpStatus;
    }

}
