package com.jalasoft.convert.model.ocrconvert;

import net.sourceforge.tess4j.TesseractException;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.model.extractors.OCR;
/**
 * It is responsible to test the OCR Class, this class convert the file with a list
 * @author Rodrigo Valda
 * @version 1.0
 */
public class OCRTest {

    @Test (expected = ExtractorException.class)
    public void should() throws ExtractorException {
        OCR ocr = new OCR();

        List<String> params = new ArrayList<>();
        params.add("testResources\\testImage.png");
        params.add("eng");
        ocr.extract(params);
    }
}
