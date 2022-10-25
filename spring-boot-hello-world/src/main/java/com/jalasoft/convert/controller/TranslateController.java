package com.jalasoft.convert.controller;

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

  @Autowired
    private FileStorageService fileStorageService;
    

  @PostMapping("/uploadGText")
    public ResponseEntity<Object> translateGt(@RequestParam("text") MultipartFile file, 
                            @RequestParam("langI") String langI,
                            @RequestParam("langO") String langO) throws IOException{
      
      String fileName = fileStorageService.storeFile(file);
      String path = "Uploads\\"+fileName;
    
      TxtFile tFile = new TxtFile();
      tFile.getPath(path,langI,langO);
                                
      return downloadFile(tFile.getNewPath());
    }

    public ResponseEntity<Object> downloadFile(String pathOcr) throws IOException {
      String filename = pathOcr;
      File file = new File(filename);
      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
      HttpHeaders headers = new HttpHeaders();

      headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
      headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
      headers.add("Pragma", "no-cache");
      headers.add("Expires", "0");

      ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(
              file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

      return responseEntity;
  }

}