package com.laptopshopping.laptopshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SaveErrorException extends Exception{

    public SaveErrorException(String message) { super(message); }

}