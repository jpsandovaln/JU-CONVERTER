package com.jalasoft.springboothelloworld.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.model.Executor;
import com.jalasoft.springboothelloworld.model.commandbuilder.ImageCommand;
import com.jalasoft.springboothelloworld.response.ImageUploadResponse;
/**
 * It is responsable for uploading Images and converting them 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */

@RestController
public class ImageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadImage")
    public ImageUploadResponse uploadImage(@RequestParam("process") String process, //MultipartFile file
                                        @RequestParam("file") MultipartFile file,
                                        @RequestParam("tool") String tool,
                                        @RequestParam("width_black") String width_black,
                                        @RequestParam("height_white") String height_white,
                                        @RequestParam("color") String color,
                                        @RequestParam("fileout") String fileout,
                                        @RequestParam("format") String format) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        List<String> settings = new ArrayList<>();
        String name = "E:\\workspacejala\\progra102\\JU-CONVERTER\\Uploads\\";
        settings.add(process);
        settings.add("Uploads\\" + fileName);
        settings.add(tool);
        settings.add(width_black);
        settings.add(height_white);
        settings.add(color);
        settings.add("Download\\" + fileout);
        settings.add(format);

        ImageCommand imageconverter = new ImageCommand(settings);

        System.out.println("final command" + imageconverter.getCommand());
        Executor executor = new Executor();
        executor.runCommand(imageconverter.getCommand());

        return new ImageUploadResponse(process,
                 fileName, tool, width_black, height_white,color, fileout, format); //toolcolor, color,
    }
}