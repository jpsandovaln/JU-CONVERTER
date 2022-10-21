package com.jalasoft.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.solr.SolrProperties;
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
        /*InputStream inputStream = new FileInputStream(pathFile.toFile());

        public void write(MultipartFile file, Path dir) {
            Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());

            try (OutputStream os = Files.newOutputStream(filepath)) {
                os.write(file.getBytes());
            }
        }

        public void multipartFileToFile(
         MultipartFile multipart,
            Path dir
         ) throws IOException {
        Path filepath = Paths.get(dir.toString(), multipart.getOriginalFilename());
        multipart.transferTo(filepath);*/

        Path targetLocation = fileStorageService.fileStorageLocation.resolve(fileName);
        System.out.print("---------------------------------------------");

        System.out.println(targetLocation.toString());
        String paths = "../../../../../../../../../Uploads";
        String name = "\\Uploads\\";
        File metadataFile = new File("C:\\Users\\RODRIGO\\PROG102\\Uploads\\786341.jpg");
        System.out.print("---------------------------------------------");
        System.out.println(file.getOriginalFilename());
        System.out.println(metadataFile.getAbsolutePath());
        System.out.println(metadataFile.getName());
        System.out.println(metadataFile.getPath());
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
