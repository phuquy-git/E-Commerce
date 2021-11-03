package com.laptopshopping.laptopshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CreateDataFailException extends Exception {
    public CreateDataFailException(String message) {
        super(message);
    }
}
