package com.jalasoft.convert.controller;

import com.jalasoft.convert.model.service.FileStorageService;
import com.jalasoft.convert.model.service.ConvertWordDocumentToPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

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
    public void readDoc(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        Path pathFile = fileStorageService.save(file);
        InputStream inputStream = new FileInputStream(pathFile.toFile());
        documentWord.convertWordDocument(inputStream, response.getOutputStream());

        response.addHeader("Content-disposition", "attachment; filename=" + "doc.pdf");
        response.setContentType("application/pdf");
        response.flushBuffer();
    }
}
