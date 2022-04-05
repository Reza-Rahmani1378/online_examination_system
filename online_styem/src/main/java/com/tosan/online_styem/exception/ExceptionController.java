package com.tosan.online_styem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = BadInputRunTimeException.class)
    public ResponseEntity<String> handle(BadInputRunTimeException b) {

        return new ResponseEntity<>(
                b.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }
}
