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
        File f = new File(FILE_TXT);
        proc.redirectOutput(f);
        proc.start();
        return f;
    }
}