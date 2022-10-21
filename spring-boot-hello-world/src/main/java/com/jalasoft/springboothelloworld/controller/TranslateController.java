package com.jalasoft.springboothelloworld.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.model.translatefiletxt.*;



@RestController
public class TranslateController {

  @Autowired
    private FileStorageService fileStorageService;
    

  @PostMapping("/uploadGText")
    public void translateGt(@RequestParam("text") MultipartFile file, 
                            @RequestParam("langI") String langI,
                            @RequestParam("langO") String langO){
    
    String fileName = fileStorageService.storeFile(file);
    String path = "Uploads\\"+fileName;
  
    TxtFile tFile = new TxtFile();
    tFile.getPath(path,langI,langO);
    tFile.getNewPath();

  }
}
