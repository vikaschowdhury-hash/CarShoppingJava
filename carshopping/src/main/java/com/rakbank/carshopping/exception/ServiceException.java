package com.rakbank.carshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Unexpected error.")
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

}
