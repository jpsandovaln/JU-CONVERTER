/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.response.AudioUploadResponse;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.commandbuilder.AudioCommand;
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
 * It is responsable for uploading Audios and converting them
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class AudioController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadAudio")
    public ResponseEntity<Object> uploadAudio(@RequestParam("file") MultipartFile file,
                                              @RequestParam("bitrate") String bitrate,
                                              @RequestParam("channels") String channels,
                                              @RequestParam("sampling frequency") String samplingFrequency,
                                              @RequestParam("format") String format) {
        try {
            Logger LOG = new At18Logger().getLogger();
            String fileName = fileStorageService.storeFile(file);
            LOG.info("File uploaded: " + fileName);
            List<String> parameters = new ArrayList<>();
            String name = "Uploads\\";
            parameters.add(fileName);
            parameters.add(bitrate);
            parameters.add(channels);
            parameters.add(samplingFrequency);
            parameters.add(format);
            AudioCommand audioConverter = new AudioCommand(name + fileName);
            audioConverter.setParameters(parameters);
            Executor executor = new Executor();
            executor.runCommand(audioConverter.getCommand());
            return ResponseEntity.ok().body(new AudioUploadResponse(fileName, file.getContentType(), file.getSize(), bitrate, channels, samplingFrequency, format));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }
}