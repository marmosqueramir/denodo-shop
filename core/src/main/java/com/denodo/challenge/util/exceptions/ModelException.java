package com.denodo.challenge.util.exceptions;

public class ModelException extends Exception {

    private final Exception innerException;

    public ModelException(Exception innerException) {
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }

    @Override
    public String getMessage() {
        return this.innerException.getMessage();
    }

    @Override
    public void printStackTrace() {
        innerException.printStackTrace();
    }

}
