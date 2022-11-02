package com.jalasoft.convert.common.exception;

public class MiddlewareException extends Exception{
    public MiddlewareException(String message) {
        super(message);
    }

    public MiddlewareException(String message, Throwable ex) {
        super(message,ex);
    }
}
