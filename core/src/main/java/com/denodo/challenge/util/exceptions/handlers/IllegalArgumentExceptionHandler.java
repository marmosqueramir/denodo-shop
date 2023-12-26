package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ErrorResponseDTO;
import com.denodo.challenge.util.exceptions.ResponseEntityConstructor;
import org.jboss.logging.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IllegalArgumentExceptionHandler {

    private static final Logger log = Logger.getLogger(IllegalArgumentExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e);
        ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntityConstructor.getErrorResponse(error);
    }

}