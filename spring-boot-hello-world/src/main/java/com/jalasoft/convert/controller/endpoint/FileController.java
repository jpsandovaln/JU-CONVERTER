/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.middleware.FileControllerMiddleware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.response.UploadFileResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * It is responsable for uploading and downloading all type of files 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class FileController {

    FileControllerMiddleware fileControllerMiddleware = new FileControllerMiddleware();
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return fileControllerMiddleware.uploadFileMiddleware(file, fileStorageService);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        return  fileControllerMiddleware.downloadFileMiddleware(fileName, request, fileStorageService);
    }
}