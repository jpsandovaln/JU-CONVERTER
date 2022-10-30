/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private String message = "Hello World";

    @GetMapping("/hello-world")
    public String HelloWorld() {
        return message;
    }
   /*@PostMapping(){}
    @DeleteMapping(){}
    @PutMapping(){}*/
}
