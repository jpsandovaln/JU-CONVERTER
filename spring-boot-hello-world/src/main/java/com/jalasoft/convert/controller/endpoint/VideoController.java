/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.common.exception.ConverterFileException;
import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.coverters.VideoCommandAdapterConvert;
import com.jalasoft.convert.model.coverters.VideoConverterConfigurationValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * It is responsable for uploading Video and converting them
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
    public Response uploadVideo(@RequestParam("file") MultipartFile file,
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
                                @RequestParam("cropVideo") String cropVideo, HttpServletResponse response) {
        try {
            String fileName = fileStorageService.storeFile(file);
            LOG.fine("File uploaded: " + fileName);
            VideoCommandAdapterConvert videoCommandAdapterConvert = new VideoCommandAdapterConvert();
            VideoConverterConfigurationValues setting = new VideoConverterConfigurationValues(fileName, newName, outFormat, volume,
                    removeAudio, videoBitrate, audioBitrate, videoFragment, rotate, fps, color, size, cropVideo);
            videoCommandAdapterConvert.initializeConfiguration(setting);
            videoCommandAdapterConvert.convert(file.getInputStream(), response.getOutputStream());
            response.addHeader("Content-disposition", "attachment; filename=" + "test.avi");
            response.setContentType("application/pdf");
            response.flushBuffer();
            return new Response("200");
        } catch (Exception e) {
            return new ErrorResponse("400", e.getMessage());
        }
    }
}