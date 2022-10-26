package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.logger.At18Logger;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.response.UploadFileResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class FileControllerMiddleware {
    private static final Logger LOG = new At18Logger().getLogger();

    public UploadFileResponse uploadFileMiddleware(MultipartFile file, FileStorageService fileStorageService) {
        try {
            if (file.getContentType() != null && file.getSize() > 12000 ){
                String fileName = fileStorageService.storeFile(file);
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/downloadFile/")
                        .path(fileName)
                        .toUriString();

                return new UploadFileResponse(fileName, fileDownloadUri,
                        file.getContentType(), file.getSize());
            } else {
                LOG.info("the file is Emtpy or there is no file");
            }
        } catch (InstantiationError ie){
            LOG.info("Catch Instantiation Error: " + ie);
            ie.printStackTrace();
        } catch (NullPointerException nulle){
            LOG.info("Catch a null pointer exception: " + nulle);
            nulle.printStackTrace();
        }
        return null;
    }

    public ResponseEntity<Resource> downloadFileMiddleware(String fileName, HttpServletRequest request, FileStorageService fileStorageService) {
        try{
            // Loads the file as a Resource
            Resource resource = fileStorageService.loadFileAsResource(fileName);

            // Identify the file's type
            String contentType = null;
            try {
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException ex) {
                LOG.info("Could not determine file type.");
            }

            // If content type if type could not be determined
            if(contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (InstantiationError ie){
            LOG.info("Catch Instantiation Error: " + ie);
            ie.printStackTrace();
        } catch (NullPointerException nulle){
            LOG.info("Catch a null pointer exception: " + nulle);
            nulle.printStackTrace();
        }
        return null;
    }
}
