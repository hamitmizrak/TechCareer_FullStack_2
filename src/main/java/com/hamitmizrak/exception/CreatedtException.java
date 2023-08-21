package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 201: Createt
@ResponseStatus(HttpStatus.CREATED)
public class CreatedtException extends RuntimeException{
    public CreatedtException(String message) {
        super(message);
    }
}
