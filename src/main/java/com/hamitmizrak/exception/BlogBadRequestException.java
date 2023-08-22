package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 400:Kötü istek
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BlogBadRequestException extends RuntimeException{
    public BlogBadRequestException(String message) {
        super(message);
    }
}
