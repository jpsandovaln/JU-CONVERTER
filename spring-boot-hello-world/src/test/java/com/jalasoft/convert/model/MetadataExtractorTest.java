package com.jalasoft.convert.model;

import com.jalasoft.convert.common.exception.ExtractorException;
import org.junit.Test;
import com.jalasoft.convert.model.extractors.MetadataExtractor;
import java.util.ArrayList;
import java.util.List;

public class MetadataExtractorTest {
    /**
     * It is responsible to test the MetadataExtractor Class, this class return a exception if insert a corrupt file
     * @author Rodrigo Valda
     * @version 1.0
     */
    @Test (expected = ExtractorException.class)
    public void shouldTestIfReturnAnOutputFileWithIOException() throws ExtractorException {
        MetadataExtractor metadataExtractor = new MetadataExtractor();
        List<String> params = new ArrayList<>();
        params.add("java/com/jalasoft/convert/middleware/prooffiles/Trouble.txt");
        metadataExtractor.extract(params);
    }
}
