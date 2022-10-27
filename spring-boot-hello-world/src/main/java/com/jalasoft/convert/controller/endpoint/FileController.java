/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;
import com.jalasoft.convert.common.exception.FileNotFoundException;
import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.common.exception.MalformedUrlException;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.response.UploadFileResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jalasoft.convert.controller.service.FileStorageService;

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

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileStorageService.storeFile(file);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
            return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
        } catch (FileStorageException e) {
            return new ErrorResponse("400", e.getLocalizedMessage());
        }
        
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Object> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Loads the file as a Resource
        Resource resource = null;
        // Identify the file's type
        String contentType = null;
        try {
            resource = fileStorageService.loadFileAsResource(fileName);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            // If content type if type could not be determined
            if(contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedUrlException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        } catch (FileNotFoundException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Could not determine file type."));
        }
    }
}