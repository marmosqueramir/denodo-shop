package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ErrorResponseDTO;
import com.denodo.challenge.util.exceptions.ResponseEntityConstructor;
import com.denodo.challenge.util.exceptions.ServiceException;
import org.jboss.logging.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServiceExceptionHandler {

    private static final Logger log = Logger.getLogger(ServiceExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponseDTO> handleServiceException(ServiceException e) {
        log.error(e);
        return ResponseEntityConstructor.getErrorResponse(e, e.getMessage());
    }
}
