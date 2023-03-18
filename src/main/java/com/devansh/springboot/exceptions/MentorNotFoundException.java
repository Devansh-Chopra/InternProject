package com.devansh.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MentorNotFoundException extends RuntimeException{

    public MentorNotFoundException(int mentorId) {
        super("No Mentor found with the given Id: "+mentorId);
    }

}
