package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.controller.service.ConvertWordDocumentToPDF;
import com.jalasoft.convert.middleware.DocControllerMiddleware;
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
    DocControllerMiddleware docControllerMiddleware = new DocControllerMiddleware();
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private ConvertWordDocumentToPDF documentWord;

    @PostMapping("/convertdocument")
    public void readDoc(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        docControllerMiddleware.readDocFunctionality(file, response, fileStorageService, documentWord);
    }
}
