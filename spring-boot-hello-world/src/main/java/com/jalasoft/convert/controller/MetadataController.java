package com.jalasoft.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;

import com.jalasoft.convert.FileStorageService;
import com.jalasoft.convert.model.MetadataExtractor;
import com.jalasoft.convert.response.MetadataUploadResponse;

@RestController
public class MetadataController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/metadata")
    public MetadataUploadResponse uploadMetadata(@RequestParam("file") MultipartFile file,
                                            @RequestParam("outFormat") String newFormat) throws IllegalStateException, IOException {
        String fileName = fileStorageService.storeFile(file);

        File metadataFile = new File(fileName);
        file.transferTo(metadataFile);

        MetadataExtractor metadata = new MetadataExtractor(metadataFile);
        File newFile = metadata.extractMetadataTxt();

        Path path = Paths.get(newFile.getPath());
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        MultipartFile newMetadata = new MockMultipartFile("metadata.txt", "metadata.txt", "text/plain", content);
        String fileMetadataName = fileStorageService.storeFile(newMetadata);
        String metadataDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileMetadataName)
                .toUriString();
        return new MetadataUploadResponse(fileName,fileMetadataName, metadataDownloadUri);
    }

}
