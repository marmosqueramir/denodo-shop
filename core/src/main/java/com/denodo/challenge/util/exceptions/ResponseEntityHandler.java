package com.denodo.challenge.util.exceptions;

import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.springframework.http.ResponseEntity;

@Provider
public class ResponseEntityHandler {

    private ResponseEntityHandler() {
        // Empty constructor
    }

    public static ResponseEntity<ErrorResponseDTO> getErrorResponse(ServiceException e, int errorCode, String message) {
        String exceptionName =
                e.getInnerExcept() != null ? e.getInnerExcept().getClass().getSimpleName() : "";
        HttpStatus status;
        switch (exceptionName) {
            case "InstanceNotFoundException":
                status = HttpStatus.NOT_FOUND;
                break;
            case "ForbiddenException":
                status = HttpStatus.FORBIDDEN;
                break;
            case "ValidationException":
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }
        return getErrorResponse(new ErrorResponseDTO(errorCode, message));
    }

    public static ResponseEntity<ErrorResponseDTO> getErrorResponse(ErrorResponseDTO error) {
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getErrorCode()));
    }

    public static ResponseEntity<Object> getOkMessage(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }
}
