package com.jalasoft.springboothelloworld.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.response.ImageUploadResponse;


@RestController
public class ImageController {

List<String> settings = new ArrayList<String>();

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadImage")
    public ImageUploadResponse uploadImage(@RequestParam("file") MultipartFile file,
                                        @RequestParam("process") String process,
                                        @RequestParam("tool") String tool,
                                        @RequestParam("width_black") String width_black,
                                        @RequestParam("height_white") String height_white,
                                        @RequestParam("color") String color,
                                        @RequestParam("fileout") String fileout,
                                        @RequestParam("format") String format) {
        String fileName = fileStorageService.storeFile(file);   
        settings.add(fileName);
        settings.add(process);
        settings.add(tool);
        settings.add(width_black);
        settings.add(height_white);
        settings.add(color);
        settings.add(fileout);
        settings.add(format);

        return new ImageUploadResponse(fileName,
                 process, tool, width_black, height_white, color, fileout, format);
    }
}