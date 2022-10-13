package com.jalasoft.springboothelloworld.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.response.VideoUploadResponse;



@RestController
public class VideoController {

List<String> settings = new ArrayList<String>();

    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadVideo")
    public VideoUploadResponse uploadVideo(@RequestParam("file") MultipartFile file,
                                        @RequestParam("newName") String newName,
                                        @RequestParam("outFormat") String outFormat,
                                        @RequestParam("volume") String volume,
                                        @RequestParam("removeAudio") String removeAudio,
                                        @RequestParam("videoBitrate") String videoBitrate,
                                        @RequestParam("audioBitrate") String audioBitrate,
                                        @RequestParam("fps") String fps,
                                        @RequestParam("color") String color,
                                        @RequestParam("size") String size) {
        String fileName = fileStorageService.storeFile(file);   
        settings.add(fileName);
        settings.add(newName);
        settings.add(outFormat);
        settings.add(volume);
        settings.add(removeAudio);
        settings.add(videoBitrate);
        settings.add(audioBitrate);
        settings.add(fps);
        settings.add(color);
        settings.add(size);

        return new VideoUploadResponse(fileName,
                file.getContentType(), newName, outFormat, volume, removeAudio, videoBitrate, audioBitrate, fps, color, size);
    }

}