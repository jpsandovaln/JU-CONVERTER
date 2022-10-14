/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.springboothelloworld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jalasoft.springboothelloworld.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class })

public class FileDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileDemoApplication.class, args);
    }
}
