/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.convert.controller.service.ConvertImageToTextOCR;

import com.jalasoft.convert.controller.service.FileStorageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * It is responsible for reading images and converting them to text
 *
 * @author Jose Romay
 * @version 1.0
 */

@RestController
public class OcrController {

    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping("/uploadOcrImg")
    public ResponseEntity<Object> translateGt(@RequestParam("img") MultipartFile file,
            @RequestParam("lang") String lang) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        ConvertImageToTextOCR convert = new ConvertImageToTextOCR();
        convert.convertImageToText(fileName, lang);
        return  downloadFile(convert.getPathOcr());
    }

    public ResponseEntity<Object> downloadFile(String pathOcr) throws IOException  {
       String filename = pathOcr;
       File file = new File(filename);
       InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
       HttpHeaders headers = new HttpHeaders();
       
       headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
       headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
       headers.add("Pragma", "no-cache");
       headers.add("Expires", "0");
       
       ResponseEntity<Object> 
       responseEntity = ResponseEntity.ok().headers(headers).contentLength(
          file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);
       
       return responseEntity;
    }
    
}
