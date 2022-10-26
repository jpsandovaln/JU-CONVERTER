package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.Executor;
import com.jalasoft.convert.model.commandbuilder.AudioCommand;
import com.jalasoft.convert.model.response.AudioUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AudioControllerMiddleware {
    private static final Logger LOG = new At18Logger().getLogger();

    public AudioUploadResponse uploadAudioFile(MultipartFile file,
                                               String bitrate,
                                               String channels,
                                               String samplingFrequency,
                                               String format,
                                               FileStorageService fileStorageService) throws IOException {
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
        } catch (IOException ioe){
            LOG.info("Catch IO error: " + ioe);
            ioe.printStackTrace();
        } catch (InstantiationError ie){
            LOG.info("Catch Instantiation Error: " + ie);
            ie.printStackTrace();
        } catch (NullPointerException nulle){
            LOG.info("Catch a null pointer exception: " + nulle);
            nulle.printStackTrace();
        }
        return null;
    }
}
