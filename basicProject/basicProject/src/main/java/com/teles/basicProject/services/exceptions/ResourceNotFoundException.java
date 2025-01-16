package com.teles.basicProject.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    public static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not Found. Id "+ id);
    }
}
