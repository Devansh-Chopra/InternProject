package com.devansh.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InternNotFoundException extends RuntimeException {
    public InternNotFoundException(int internId) {

        super("No Intern found with the given Id: "+internId);
    }
}
