package com.laptopshopping.laptopshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BrandIdNotFoundException extends Exception{

    public BrandIdNotFoundException(String message) { super(message); }

}
