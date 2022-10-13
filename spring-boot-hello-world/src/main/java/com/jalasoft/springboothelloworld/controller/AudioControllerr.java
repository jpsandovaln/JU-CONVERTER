package com.jalasoft.springboothelloworld.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jalasoft.springboothelloworld.FileStorageService;
import com.jalasoft.springboothelloworld.model.Executor;
import com.jalasoft.springboothelloworld.model.converter.AudioConverter;
import com.jalasoft.springboothelloworld.response.AudioUploadResponse;



@RestController
public class AudioControllerr {


    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadAudio")
    public AudioUploadResponse uploadAudio(@RequestParam("file") MultipartFile file,
                                        @RequestParam("bitrate") String bitrate,
                                        @RequestParam("channels") String channels,
                                        @RequestParam("encode") String encode,
                                        @RequestParam("format") String format) throws IOException {
        String fileName = fileStorageService.storeFile(file);
        List<String> parameters = new ArrayList<>();
        String name = "Uploads\\";
        //parameters.add(name);
        parameters.add(bitrate);
        parameters.add(channels);
        parameters.add(encode);
        parameters.add(format);
        AudioConverter audioConverter = new AudioConverter(parameters, name + fileName);
        //System.out.println(audioConverter.getCommand());
        Executor executor = new Executor();
        executor.runCommand(audioConverter.getCommand());
        return new AudioUploadResponse(fileName,
                file.getContentType(), file.getSize(), bitrate, channels, encode, format);
    }

}