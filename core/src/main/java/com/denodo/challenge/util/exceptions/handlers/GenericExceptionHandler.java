package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ErrorResponseDTO;
import com.denodo.challenge.util.exceptions.ResponseEntityConstructor;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    private static final Logger log = Logger.getLogger(GenericExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
        log.error(e, e);
        log.error(e.getClass().getCanonicalName());
        ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR,"unknown error: " + e.getMessage());
        return ResponseEntityConstructor.getErrorResponse(error);
    }
}
