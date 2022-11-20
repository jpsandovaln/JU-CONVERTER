/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.ImageUploadResponse;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.commandbuilder.ImageCommand;
import com.jalasoft.convert.model.executor.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * It is responsible for uploading Images and converting them
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class ImageController {
    private static final Logger LOG = new At18Logger().getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadImage")
    public ResponseEntity<Object> uploadImage(@RequestParam("process") String process, //MultipartFile file
                                              @RequestParam("file") MultipartFile file,
                                              @RequestParam("tool") String tool,
                                              @RequestParam("width_black") String width_black,
                                              @RequestParam("height_white") String height_white,
                                              @RequestParam("color") String color,
                                              @RequestParam("fileout") String fileout,
                                              @RequestParam("format") String format) {

        try {
            LOG.info("An image was introduced correctly");
            String fileName = fileStorageService.storeFile(file);
            LOG.info("File uploaded: " + fileName);
            List<String> settings = new ArrayList<>();
            settings.add(process);
            settings.add(System.getProperty("user.dir") + "/Uploads/" + fileName);
            settings.add(tool);
            settings.add(width_black);
            settings.add(height_white);
            settings.add(color);
            settings.add(System.getProperty("user.dir") + "/Download/" + fileout);
            settings.add(format);
            ImageCommand imageConverter = new ImageCommand(settings);
            LOG.info("final command" + imageConverter.getCommand());
            Executor executor = new Executor();
            executor.runCommand(imageConverter.getCommand());
            return ResponseEntity.ok().body(new ImageUploadResponse(process, fileName, tool, width_black, height_white, color, fileout, format));
        } catch (ExecuteException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        } catch (FileStorageException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }
}