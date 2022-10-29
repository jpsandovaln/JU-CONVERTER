package com.jalasoft.convert.controller.service;

/**
 * It is responsible for receiving images and converting them to text
 *
 * @author Hugo Solares
 * @version 1.0
 */
import com.jalasoft.convert.model.ocrconvert.OCR;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

@Service
public class ConvertImageToTextOCR {
    private String pathOcr;
    public void convertImageToText(String imageInputname, String lang) throws TesseractException {
        OCR imageOCR = new OCR();
        imageOCR.convertOCR(imageInputname, lang);
        pathOcr=imageOCR.getPathOcr();
    }
    public String getPathOcr() {
        return pathOcr;
    }
}
