/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import com.jalasoft.convert.middleware.AudioControllerMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.model.Executor;
import com.jalasoft.convert.model.commandbuilder.AudioCommand;
import com.jalasoft.convert.model.response.AudioUploadResponse;

/**
 * It is responsable for uploading Audios and converting them 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class AudioControllerr {

    AudioControllerMiddleware audioControllerMiddleware = new AudioControllerMiddleware();
    private static final Logger LOG = new At18Logger().getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadAudio")
    public AudioUploadResponse uploadAudio(@RequestParam("file") MultipartFile file,
                                        @RequestParam("bitrate") String bitrate,
                                        @RequestParam("channels") String channels,
                                        @RequestParam("sampling frequency") String samplingFrequency,
                                        @RequestParam("format") String format) throws IOException {
        return audioControllerMiddleware.uploadAudioFile(file, bitrate, channels, samplingFrequency, format, fileStorageService);
    }

}