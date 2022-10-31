package com.jalasoft.convert.model.ocrconvert;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

public class OCRTest {

    @Test (expected = TesseractException.class)
    public void should() throws TesseractException {
        OCR ocr = new OCR();
        ocr.convertOCR("testResources\\testImage.png",
                "eng");
    }
}
