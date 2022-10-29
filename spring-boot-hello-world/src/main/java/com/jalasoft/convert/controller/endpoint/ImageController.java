package com.jalasoft.convert.controller.endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.common.logger.At18Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.ImageUploadResponse;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.executor.Executor;
import com.jalasoft.convert.model.commandbuilder.ImageCommand;
/**
 * It is responsable for uploading Images and converting them 
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
    public Response uploadImage(@RequestParam("process") String process, //MultipartFile file
                                        @RequestParam("file") MultipartFile file,
                                        @RequestParam("tool") String tool,
                                        @RequestParam("width_black") String width_black,
                                        @RequestParam("height_white") String height_white,
                                        @RequestParam("color") String color,
                                        @RequestParam("fileout") String fileout,
                                        @RequestParam("format") String format){

        try {
            String fileName = fileStorageService.storeFile(file);
            List<String> settings = new ArrayList<>();
            settings.add(process);
            settings.add("Uploads\\" + fileName);
            settings.add(tool);
            settings.add(width_black);
            settings.add(height_white);
            settings.add(color);
            settings.add("Download\\" + fileout);
            settings.add(format);
            ImageCommand imageconverter = new ImageCommand(settings);
            LOG.info("final command" + imageconverter.getCommand());
            Executor executor = new Executor();
            executor.runCommand(imageconverter.getCommand());
            return new ImageUploadResponse(process,
                    fileName, tool, width_black, height_white,color, fileout, format);
        } catch (ExecuteException | FileStorageException e) {
            return new ErrorResponse("400", e.getMessage());
        }
    }
}