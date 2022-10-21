package com.jalasoft.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

import com.jalasoft.convert.FileStorageService;
//import com.jalasoft.convert.model.MetadataExtractor;
import com.jalasoft.convert.response.MetadataUploadResponse;

@RestController
public class MetadataController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/metadata")
    public MetadataUploadResponse uploadMetadata(@RequestParam("file") MultipartFile file,
                                            @RequestParam("outFormat") String newFormat) throws IllegalStateException, IOException {
        String fileName = fileStorageService.storeFile(file);
        Path targetLocation = fileStorageService.fileStorageLocation.resolve(fileName);

        File metadataFile = new File(targetLocation.toString());
        file.transferTo(metadataFile);

        //MetadataExtractor metadata = new MetadataExtractor(metadataFile);
        //File newFile = metadata.extractMetadataTxt();

        /*String metadataDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(newFile.getName())
                .toUriString(); */

        return new MetadataUploadResponse(fileName,newFormat, "a");//metadataDownloadUri);
    }

}
