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
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.response.VideoUploadResponse;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import com.jalasoft.convert.model.coverters.VideoCommandAdapterConvert;
import com.jalasoft.convert.model.coverters.VideoConverterConfigurationValues;
import com.jalasoft.convert.model.executor.Executor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;
/**
 * It is responsible for uploading Video and converting them
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class VideoController {

    private static final Logger LOG = new At18Logger().getLogger();
    List<String> settings = new ArrayList<String>();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadVideo")
    // public VideoUploadResponse uploadVideo(@RequestParam("file") MultipartFile file,
    public ResponseEntity<Object> uploadVideo(@RequestParam("file") MultipartFile file,
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
                                @RequestParam("cropVideo") String cropVideo) {
        try {
            String fileName = fileStorageService.storeFile(file);
            LOG.fine("File uploaded: " + fileName);
            List<String> parameters = new ArrayList<>();
            parameters.add(System.getProperty("user.dir") + "/Uploads/" + fileName);
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
            VideoCommand videoCommand = new VideoCommand();
            videoCommand.setParameters(parameters);
            Executor executor = new Executor();
            executor.runCommand(videoCommand.getCommand());
            return ResponseEntity.ok().body(new VideoUploadResponse(fileName, newName, outFormat, volume, removeAudio, videoBitrate, audioBitrate, fps,  color, size));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }
}