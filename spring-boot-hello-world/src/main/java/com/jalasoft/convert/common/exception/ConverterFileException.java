/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.common.exception;
/**
 * It takes care of the exception at the time of converting
 *
 * @author Libertad Tolaba
 * @version 1.0
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConverterFileException extends Exception{
    public ConverterFileException(String message) {
        super(message);
    }
    public ConverterFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
