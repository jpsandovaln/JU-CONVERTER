package com.jalasoft.convert.model;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MetadataExtractorTest {
    @Test (expected = IOException.class)
    public void shouldTestIfReturnAnOutputFileWithIOException() throws IOException {
        File fileTest = new File("Downloads/justnew.txt");
        MetadataExtractor metadataExtractor = new MetadataExtractor(fileTest);
        metadataExtractor.extractMetadataTxt();
    }

    @Test
    public void shouldTestIfReturnAnOutputFile() throws IOException {
        File fileTest = new File("Downloads\\justnew.txt");
        MetadataExtractor metadataExtractor = new MetadataExtractor(fileTest);
        System.out.println(metadataExtractor.extractMetadataTxt());
    }
}
