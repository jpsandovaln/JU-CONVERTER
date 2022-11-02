/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.coverters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.jalasoft.convert.controller.service.FileStorageService;

import net.sourceforge.tess4j.TesseractException;

public class MetadataExtractor extends Extractor{
    public static final String EXIFTOOL = "exiftool";
    public static final String FILE_TXT = "Uploads/file.txt";
    private FileStorageService fileStorageService;
    private File outputFile;

    public MetadataExtractor(){

    }

    @Override
    public void extract(List<String> params) throws TesseractException {
        try {
            File file = new File(params.get(0));
            ProcessBuilder proc= new ProcessBuilder().command(EXIFTOOL, file.getPath());
            proc.redirectErrorStream(true);
            outputFile = new File(FILE_TXT);
            proc.redirectOutput(outputFile);    
            proc.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(){
        return outputFile;
    }
}