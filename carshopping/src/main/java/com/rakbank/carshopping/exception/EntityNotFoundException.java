package com.rakbank.carshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not found entity with id.")
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(String message) {
        super(message);
    }

}
