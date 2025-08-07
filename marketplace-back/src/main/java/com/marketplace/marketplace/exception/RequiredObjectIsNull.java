package com.marketplace.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNull extends RuntimeException {

    public RequiredObjectIsNull(){
        super("It's not allowed to persist a null entity");
    }
}
