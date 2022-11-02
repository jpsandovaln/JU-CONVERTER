package com.jalasoft.convert.model;

import org.junit.Test;

import com.jalasoft.convert.model.extractors.MetadataExtractor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MetadataExtractorTest {
    @Test (expected = IOException.class)
    public void shouldTestIfReturnAnOutputFileWithIOException() {
        MetadataExtractor metadataExtractor = new MetadataExtractor();
        List<String> params = new ArrayList<>();
        params.add("Downloads/justnew.txt");
        //metadataExtractor.extract(params);
    }

    @Test
    public void shouldTestIfReturnAnOutputFile() throws IOException {
        File fileTest = new File("Downloads\\justnew.txt");
        //MetadataExtractor metadataExtractor = new MetadataExtractor(fileTest);
       // System.out.println(metadataExtractor.extractMetadataTxt());
    }
}
