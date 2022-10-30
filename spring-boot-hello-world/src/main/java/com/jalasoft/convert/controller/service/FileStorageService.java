/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.service;

import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.common.exception.FileNotFoundException;
import com.jalasoft.convert.common.exception.MalformedUrlException;
import com.jalasoft.convert.controller.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * It is responsable for storing the uploaded file
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */
@Service
public class FileStorageService {

    public final Path fileStorageLocation;
    private final Path root = Paths.get("documentconvert");

    @PostConstruct
    public void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) throws FileStorageException{
        try {
            this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex); 
        }
    }

    public String storeFile(MultipartFile file) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Try again", ex);
        }
    }

    public Path save(MultipartFile file) {
        String framesPath = String.valueOf(System.currentTimeMillis());
        try {
            Files.createDirectory(Paths.get("documentconvert", framesPath));
            Path uploadsPath = Paths.get("documentconvert", framesPath, file.getOriginalFilename());
            Files.copy(file.getInputStream(), uploadsPath);
            return uploadsPath;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Resource loadFileAsResource(String fileName) throws MalformedUrlException, FileNotFoundException {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        }
        catch (MalformedURLException ex) {
            throw new MalformedUrlException("File not found " + fileName, ex);
        }
    }
}