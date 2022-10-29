package com.jalasoft.convert.common.exception;

public class RuntimeException extends Exception{
    public RuntimeException(String message) {
        super(message);
    }
    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
