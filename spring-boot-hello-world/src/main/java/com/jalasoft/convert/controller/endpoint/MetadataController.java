/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.response.MetadataUploadResponse;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.extractors.MetadataExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


/**
 * It is responsible for uploading Audios and converting them
 *
 * @author Rodrigo Bernal
 * @version 1.0
 */
@RestController
public class MetadataController {
    private static final Logger LOG = new At18Logger().getLogger();

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/metadata")
    public Response uploadMetadata(@RequestParam("file") MultipartFile file,
                                   @RequestParam("outFormat") String newFormat) {
        try {
            String fileName = fileStorageService.storeFile(file);
            LOG.info("File uploaded: " + fileName);
            Path targetLocation = fileStorageService.fileStorageLocation.resolve(fileName);
            //Convert the MultipartFile to a File
            File metadataFile = new File(targetLocation.toString());
            file.transferTo(metadataFile);

            //Extract the metadata in a new File
            MetadataExtractor metadata = new MetadataExtractor();
            List<String> filePath = new ArrayList<>();
            filePath.add(metadataFile.toPath().toString());
            metadata.extract(filePath);
            File newFile = metadata.getFile();
            //Create the link to Download the new file with the metadata
            String metadataDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(newFile.getName())
                    .toUriString();
            return new MetadataUploadResponse(fileName, newFormat, metadataDownloadUri);
        } catch (Exception e) {
            return new ErrorResponse("400", e.getMessage());
        }
    }
}
