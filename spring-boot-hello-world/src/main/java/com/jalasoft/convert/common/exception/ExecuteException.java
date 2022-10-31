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
 * It takes care of the exception
 *
 * @author Libertad Tolaba
 * @version 1.0
 */
public class ExecuteException extends Exception{
    public ExecuteException(String message) {
        super(message);
    }
    public ExecuteException(String message, Throwable cause) {
        super(message, cause);
    }
}
