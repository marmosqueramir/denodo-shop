package com.denodo.challenge.exceptions;

public class ModelException extends Exception {

    private Exception innerException;
    private ModelExceptionType type;
    private ModelExceptionSubType subType;
    private String message;

    public ModelException(Exception innerException) {
        this.innerException = innerException;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setInnerException(Exception innerException) {
        this.innerException = innerException;
    }

    public ModelExceptionType getType() {
        return type;
    }

    public void setType(ModelExceptionType type) {
        this.type = type;
    }

    public ModelExceptionSubType getSubType() {
        return subType;
    }

    public void setSubType(ModelExceptionSubType subType) {
        this.subType = subType;
    }

    @Override
    public String getMessage() {
        if (message == null) {
            return this.innerException.getMessage();
        } else {
            return message + "|| INNER EXCEPTION MESSAGE: " + this.innerException.getMessage();
        }
    }

    @Override
    public void printStackTrace() {
        innerException.printStackTrace();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum ModelExceptionType {
        CONSTRAINT, INSTANCE_NOT_FOUND
    }

    public enum ModelExceptionSubType {
        FOREIGN_KEY
    }
}
