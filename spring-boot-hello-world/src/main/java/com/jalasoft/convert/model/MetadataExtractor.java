/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model;

import java.io.File;
import java.io.IOException;

public class MetadataExtractor {
    public static final String EXIFTOOL = "exiftool";
    public static final String FILE_TXT = "Uploads/file.txt";
    private File file;

    public MetadataExtractor(File file) {
        this.file = file;
    }

    public File extractMetadataTxt() throws IOException {
        ProcessBuilder proc= new ProcessBuilder().command(EXIFTOOL, file.getPath());
        proc.redirectErrorStream(true);
        File outputFile = new File(FILE_TXT);
        proc.redirectOutput(outputFile);
        proc.start();
        return outputFile;
    }
}