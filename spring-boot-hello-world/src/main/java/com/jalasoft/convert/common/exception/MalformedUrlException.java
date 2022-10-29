package com.jalasoft.convert.common.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MalformedUrlException extends Exception{
    public MalformedUrlException(String message) {
        super(message);
    }
    public MalformedUrlException(String message, Throwable cause) {
        super(message, cause);
    }
}
