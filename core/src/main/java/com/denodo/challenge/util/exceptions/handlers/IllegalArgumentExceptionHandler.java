package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ErrorResponseDTO;
import com.denodo.challenge.util.exceptions.ResponseEntityHandler;
import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionHandler implements ExceptionMapper<IllegalArgumentException> {

    private static final Logger log = Logger.getLogger(IllegalArgumentExceptionHandler.class);

    @Override
    public Response toResponse(IllegalArgumentException e) {
        log.error(e);
        ErrorResponseDTO error = new ErrorResponseDTO(Response.Status.BAD_REQUEST, 0, e.getMessage());
        return ResponseEntityHandler.getErrorResponse(error);
    }

}