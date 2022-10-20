package com.jalasoft.springboothelloworld.common.logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.LogManager;

public class At18Logger {
    private static final String PROPERTIES_PATH = "spring-boot-hello-world\\src\\main\\resources\\application.properties";
    private Logger log = Logger.getLogger("At18Logger");
    public At18Logger () {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(PROPERTIES_PATH));

        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
    }
    public Logger getLogger() {
        return log;
    }
}
