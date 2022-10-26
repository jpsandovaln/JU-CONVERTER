package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.middleware.TranslateControllerMiddleware;
import com.jalasoft.convert.model.translatefiletxt.TxtFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;

import com.jalasoft.convert.controller.service.FileStorageService;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class TranslateController {
  TranslateControllerMiddleware translateControllerMiddleware = new TranslateControllerMiddleware();

  @Autowired
    private FileStorageService fileStorageService;
    

  @PostMapping("/uploadGText")
    public ResponseEntity<Object> translateGt(@RequestParam("text") MultipartFile file, 
                            @RequestParam("langI") String langI,
                            @RequestParam("langO") String langO) throws IOException{
      return translateControllerMiddleware.translateGt(file, langI, langO, fileStorageService);
    }


}