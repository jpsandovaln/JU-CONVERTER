/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.extractors;

import com.jalasoft.convert.common.exception.ExtractorException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MetadataExtractor extends Extractor {
    public static final String EXIFTOOL = "exiftool";
    public static final String FILE_TXT = "Download/MetadataExtract.txt";
    private File outputFile;

    public MetadataExtractor() {
    }

    @Override
    public void extract(List<String> params) throws ExtractorException {
        try {
            File file = new File(params.get(0));
            ProcessBuilder proc = new ProcessBuilder().command(EXIFTOOL, file.getPath());
            proc.redirectErrorStream(true);
            outputFile = new File(FILE_TXT);
            proc.redirectOutput(outputFile);
            proc.start();
        } catch (IOException e) {
            throw new ExtractorException("Error with metadata extractor", e);
        }
    }

    public File getFile() {
        return outputFile;
    }
}