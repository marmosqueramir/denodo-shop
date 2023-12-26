package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ErrorResponseDTO;
import com.denodo.challenge.util.exceptions.ResponseEntityHandler;
import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger log = Logger.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(Exception e) {
        log.error(e, e);
        log.error(e.getClass().getCanonicalName());
        ErrorResponseDTO error = new ErrorResponseDTO(Response.Status.INTERNAL_SERVER_ERROR, 0,
                "unknown error: " + e.getMessage());
        return ResponseEntityHandler.getErrorResponse(error);
    }
}
