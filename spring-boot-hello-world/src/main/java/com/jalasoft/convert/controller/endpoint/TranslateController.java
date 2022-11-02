/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.endpoint;

import com.aspose.words.Document;
import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.response.ErrorResponse;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.extractors.translatefiletxt.TxtFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/uploadGText")
@RestController
public class TranslateController {
    private static final Logger LOG = new At18Logger().getLogger();
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("txt")
    public ResponseEntity<Object> translateGtTxt(@RequestParam("text") MultipartFile file,
                                                 @RequestParam("langI") String langI,
                                                 @RequestParam("langO") String langO){
        LOG.info("A txt file was introduced as input");
        try {
            String fileName = fileStorageService.storeFile(file);
            String path = "Uploads\\" + fileName;
            TxtFile tFile = new TxtFile();
            List<String> params = new ArrayList<>();
            params.add(path);
            params.add(langI);
            params.add(langO);
            //tFile.getPath(path, langI, langO);
            tFile.extract(params);
            return downloadFile(tFile.getNewPath());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }

    @PostMapping("word")
    public ResponseEntity<Object> translateGtWord(@RequestParam("text") MultipartFile file,
                                                  @RequestParam("langI") String langI,
                                                  @RequestParam("langO") String langO){
        try {
            LOG.info("A word file was introduced as input");
            String fileNameInput = fileStorageService.storeFile(file);
            Document doc = new Document("Uploads\\" + fileNameInput);
            doc.save("Uploads\\" + "File.txt");

            String path = "Uploads\\" + "File.txt";
            TxtFile tFile = new TxtFile();
            List<String> params = new ArrayList<>();
                params.add(path);
                params.add(langI);
                params.add(langO);
            //tFile.getPath(path, langI, langO);
            tFile.extract(params);
            return downloadFile(tFile.getNewPath());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }

    public ResponseEntity<Object> downloadFile(String pathOcr) throws IOException {
        String filename = pathOcr;
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(
                file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }
}