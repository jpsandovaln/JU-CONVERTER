package com.jalasoft.springboothelloworld.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.response.AudioUploadResponse;



@RestController
public class AudioControllerr {


    @Autowired
    private FileStorageService fileStorageService;
    
    @PostMapping("/uploadAudio")
    public AudioUploadResponse uploadAudio(@RequestParam("file") MultipartFile file,
                                        @RequestParam("bitrate") String bitrate,
                                        @RequestParam("channels") int channels,
                                        @RequestParam("encode") String encode,
                                        @RequestParam("format") String format) {
        String fileName = fileStorageService.storeFile(file);   

        return new AudioUploadResponse(fileName,
                file.getContentType(), file.getSize(), bitrate, channels, encode, format);
    }

}