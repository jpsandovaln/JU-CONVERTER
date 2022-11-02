package com.jalasoft.convert.model.ocrconvert;

import net.sourceforge.tess4j.TesseractException;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jalasoft.convert.model.coverters.OCR;

public class OCRTest {

    @Test (expected = TesseractException.class)
    public void should() throws TesseractException {
        OCR ocr = new OCR();
        List<String> params = new ArrayList<>();
        params.add("testResources\\testImage.png");
        params.add("eng");
        ocr.extract(params);
    }
}
