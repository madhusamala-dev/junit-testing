package com.trainingmug.junit.exception;

public class CustomerExistsException extends RuntimeException{

    public CustomerExistsException(String message) {
        super(message);
    }
}
