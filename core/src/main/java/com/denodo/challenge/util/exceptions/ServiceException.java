package com.denodo.challenge.util.exceptions;

public class ServiceException extends Exception {

    private static final String INNER_EXCEPTION_MESSAGE = "|| INNER EXCEPTION MESSAGE:";
    private final Exception innerExcept;
    private final String message;


    public ServiceException(String message) {
        this.message = message;
        this.innerExcept = null;
    }

    public ServiceException(ModelException e) {
        this.innerExcept = e;
        this.message = "";
    }


    public ServiceException(Exception e) {
        this.innerExcept = e;
        this.message = "";
    }

    public ServiceException(String message, Exception e) {
        this.innerExcept = e;
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        if (this.innerExcept != null) {
            this.innerExcept.printStackTrace();
        }
    }

    @Override
    public String getMessage() {
        String innerExceptMessage = this.innerExcept != null ? this.innerExcept.getMessage() : "";
        if (this.message == null) {
            return innerExceptMessage;
        } else {
            return message + INNER_EXCEPTION_MESSAGE + innerExceptMessage;
        }
    }

    public Exception getInnerExcept() {
        return innerExcept;
    }
}
