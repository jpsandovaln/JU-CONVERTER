package com.jalasoft.springboothelloworld.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
  private String message = "Hello World";
  
    @GetMapping("/hello-world")
    public String HelloWorld(){
      return message;
    }
    /*@PostMapping(){}
    @DeleteMapping(){}
    @PutMapping(){}*/
    
}
