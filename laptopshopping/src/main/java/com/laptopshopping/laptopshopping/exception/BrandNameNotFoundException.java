package com.laptopshopping.laptopshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BrandNameNotFoundException extends Exception{

    public BrandNameNotFoundException(String message) { super(message); }

}
