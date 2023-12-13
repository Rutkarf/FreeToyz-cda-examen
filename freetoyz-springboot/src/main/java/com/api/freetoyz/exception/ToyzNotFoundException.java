package com.api.freetoyz.exception;


import lombok.Getter;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Toyz Not Found")
@Getter

public class ToyzNotFoundException extends ResponseStatusException {


    public ToyzNotFoundException(HttpStatus status){
        super(status);
    }

    public ToyzNotFoundException(HttpStatus status, String reason){
        super(status,reason);
    }
    public ToyzNotFoundException(HttpStatus status, String reason, Throwable cause){
        super(status, reason, cause);
    }

}
