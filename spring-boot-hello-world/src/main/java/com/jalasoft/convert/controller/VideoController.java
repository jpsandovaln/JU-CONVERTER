/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.convert.FileStorageService;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.model.Executor;
import com.jalasoft.convert.model.commandbuilder.CommandBuilder;
import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import com.jalasoft.convert.response.VideoUploadResponse;
/**
 * It is responsable for uploading Video and converting them 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class VideoController {

List<String> settings = new ArrayList<String>();
    private static final Logger LOG = new At18Logger().getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadVideo")
    public VideoUploadResponse uploadVideo(@RequestParam("file") MultipartFile file,
                                        @RequestParam("outName") String newName,
                                        @RequestParam("outFormat") String outFormat,
                                        @RequestParam("volume") String volume,
                                        @RequestParam("removeAudio") String removeAudio,
                                        @RequestParam("videoBitrate") String videoBitrate,
                                        @RequestParam("audioBitrate") String audioBitrate,
                                        @RequestParam("videoFragment") String videoFragment,
                                        @RequestParam("rotate") String rotate,
                                        @RequestParam("fps") String fps,
                                        @RequestParam("color") String color,
                                        @RequestParam("size") String size,
                                        @RequestParam("cropVideo") String cropVideo) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        LOG.fine("File uploaded: " + fileName);
        List<String> parameters = new ArrayList<String>();
        parameters.add("Uploads\\" + fileName);
        
        parameters.add(newName);
        parameters.add(outFormat);
        parameters.add(volume);
        parameters.add(removeAudio);
        parameters.add(videoBitrate);
        parameters.add(audioBitrate);
        parameters.add(videoFragment);
        parameters.add(rotate);
        parameters.add(fps);
        parameters.add(color);
        parameters.add(size);
        parameters.add(cropVideo);
        
        CommandBuilder builderCommand = new VideoCommand();
        builderCommand.setParameters(parameters);
        LOG.fine("Bulding command...");
        Executor executor = new Executor();
        executor.runCommand(builderCommand.getCommand());
        LOG.fine("Executing command...");
        LOG.info("Dowload the new file");
        return new VideoUploadResponse(fileName,
                file.getContentType(), newName, outFormat, volume, removeAudio, videoBitrate, audioBitrate, fps, color, size);
    }

}