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
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.service.ConvertWordDocumentToPDF;
import com.jalasoft.convert.controller.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * It is responsable for uploading Word document created with MS Office (docx)
 * and converting it to PDF
 *
 * @author Maria Hurtado
 * @version 1.0
 */
@RestController
public class DocController {
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private ConvertWordDocumentToPDF documentWord;

    @PostMapping("/convertdocument")

    public ResponseEntity<Object> readDoc(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        try {
            Logger LOG = new At18Logger().getLogger();
            Path pathFile = fileStorageService.save(file);
            String fileName = pathFile.toString();
            LOG.info("File uploaded: " + fileName);
            InputStream inputStream = new FileInputStream(pathFile.toFile());
            documentWord.convertWordDocument(inputStream, response.getOutputStream());
            response.addHeader("Content-disposition", "attachment; filename=" + "doc.pdf");
            response.setContentType("application/pdf");
            response.flushBuffer();
            return ResponseEntity.ok().body(new Response("200"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("400", e.getMessage()));
        }
    }
}
