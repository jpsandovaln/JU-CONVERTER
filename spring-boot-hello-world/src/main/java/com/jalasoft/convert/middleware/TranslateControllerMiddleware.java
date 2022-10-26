package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.translatefiletxt.TxtFile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.aspose.words.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class TranslateControllerMiddleware {
    private static final Logger LOG = new At18Logger().getLogger();
    public ResponseEntity<Object> translateGt(MultipartFile file,
                                              String langI,
                                              String langO,
                                              FileStorageService fileStorageService){

        try {
            if (file.getContentType() != null && file.getContentType().contains("text")) {
                LOG.info("A txt file was introduced as input");
                System.out.println(file.getContentType());
                String fileName = fileStorageService.storeFile(file);
                String path = "Uploads\\"+fileName;

                TxtFile tFile = new TxtFile();
                tFile.getPath(path,langI,langO);

                return downloadFile(tFile.getNewPath());
            } else if (file.getContentType() != null && !file.getContentType().contains("text")) {
                try {
                    LOG.info("A word file was introduced as input");
                    String fileNameInput = fileStorageService.storeFile(file);
                    Document doc = new Document("Uploads\\" + fileNameInput);
                    doc.save("Uploads\\" + "File.txt");

                    String path = "Uploads\\"+"File.txt";
                    TxtFile tFile = new TxtFile();
                    tFile.getPath(path,langI,langO);

                    return downloadFile(tFile.getNewPath());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        } else {
                LOG.info("the file is Emtpy or there is no file");
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
        return null;
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
