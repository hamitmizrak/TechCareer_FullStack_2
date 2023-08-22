package com.hamitmizrak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 401:Yetkisiz Giriş
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BlogUnAuthorizedException extends RuntimeException{
    public BlogUnAuthorizedException(String message) {
        super(message);
    }
}
