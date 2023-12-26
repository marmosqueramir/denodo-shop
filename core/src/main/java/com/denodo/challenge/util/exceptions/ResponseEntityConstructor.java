package com.denodo.challenge.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityConstructor {

    private ResponseEntityConstructor() {
        // Empty constructor
    }

    public static ResponseEntity<ErrorResponseDTO> getErrorResponse(ServiceException e, String message) {
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
        return getErrorResponse(new ErrorResponseDTO(status, message));
    }

    public static ResponseEntity<ErrorResponseDTO> getErrorResponse(ErrorResponseDTO error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

    public static ResponseEntity<Object> getOkMessage(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }
}
