package com.denodo.challenge.util.exceptions.handlers;

import com.denodo.challenge.util.exceptions.ResponseEntityHandler;
import com.denodo.challenge.util.exceptions.ServiceException;
import org.jboss.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionHandler implements ExceptionMapper<ServiceException> {

    private static final Logger log = Logger.getLogger(ServiceExceptionHandler.class);

    @Override
    public Response toResponse(ServiceException e) {
        log.error(e);
        return ResponseEntityHandler.getErrorResponse(e, 0, e.getMessage());
    }
}
