/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.common.logger;

import java.io.IOException;
import java.util.logging.Logger;

import java.io.InputStream;

import java.util.logging.LogManager;

/**
 * It is responsible for initialice the Logger and associate it with the properties file.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class At18Logger {

    // Directory of the properties file
    //private static final String PROPERTIES_PATH = "spring-boot-hello-world\\src\\main\\resources\\application.properties";
    private Logger log = Logger.getLogger("At18Logger");

    public At18Logger () {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            LogManager.getLogManager().readConfiguration(in);

        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
    }
    public Logger getLogger() {
        return log;
    }
}
