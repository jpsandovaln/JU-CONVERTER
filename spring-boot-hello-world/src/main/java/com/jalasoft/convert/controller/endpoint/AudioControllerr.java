/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.FileStorageException;
<<<<<<< HEAD
import com.jalasoft.convert.controller.response.AudioUploadResponse;
=======
>>>>>>> 02bc9be (Added some Responses with exceptions)
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.model.executor.Executor;
import com.jalasoft.convert.model.commandbuilder.AudioCommand;

/**
 * It is responsable for uploading Audios and converting them 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class AudioControllerr {
    private static final Logger LOG = new At18Logger().getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadAudio")
    public Response uploadAudio(@RequestParam("file") MultipartFile file,
                                @RequestParam("bitrate") String bitrate,
                                @RequestParam("channels") String channels,
                                @RequestParam("sampling frequency") String samplingFrequency,
                                @RequestParam("format") String format){
        try {
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
            return new AudioUploadResponse(fileName,
                    file.getContentType(), file.getSize(), bitrate, channels, samplingFrequency, format);
        } catch (ExecuteException | FileStorageException e) {
            return new ErrorResponse("400",e.getMessage());
        } catch (FileStorageException e) {
            return new ErrorResponse("400",e.getMessage());
        }
    }
}