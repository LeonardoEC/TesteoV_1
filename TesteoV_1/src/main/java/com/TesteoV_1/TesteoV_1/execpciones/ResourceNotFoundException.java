package com.TesteoV_1.TesteoV_1.execpciones;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionID = 1L;

    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
