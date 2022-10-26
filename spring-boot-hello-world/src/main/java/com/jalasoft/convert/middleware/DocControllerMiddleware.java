package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.service.ConvertWordDocumentToPDF;
import com.jalasoft.convert.controller.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.logging.Logger;

@Service
public class DocControllerMiddleware {
    private static final Logger LOG = new At18Logger().getLogger();
    public void readDocFunctionality(MultipartFile file, HttpServletResponse response, FileStorageService fileStorageService, ConvertWordDocumentToPDF documentWord){
        try {
            if (file.getContentType() != null && response.getStatus() == 200) {
                Path pathFile = fileStorageService.save(file);
                InputStream inputStream = new FileInputStream(pathFile.toFile());
                documentWord.convertWordDocument(inputStream, response.getOutputStream());

                response.addHeader("Content-disposition", "attachment; filename=" + "doc.pdf");
                response.setContentType("application/pdf");
                response.flushBuffer();
            }
            else {
                LOG.info("Status is not 200 or the file is Emtpy or there is no file");
            }
        } catch (IOException ioe){
            LOG.info("Catch IO error: " + ioe);
            ioe.printStackTrace();
        } catch (InstantiationError ie){
            LOG.info("Catch Instantiation Error: " + ie);
            ie.printStackTrace();
        } catch (NullPointerException nulle){
            LOG.info("Catch a null pointer exception: " + nulle);
            nulle.printStackTrace();
        }
    }
}
