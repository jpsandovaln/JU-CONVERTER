package com.jalasoft.convert.service;

/**
 * It is responsible for receiving images and converting them to text
 *
 * @author Hugo Solares
 * @version 1.0
 */
import com.jalasoft.convert.model.ocrconvert.OCR;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConvertImageToTextOCR {
    public void convertImageToText(String imageInputname, String OutputName) throws IOException {
        OCR imageOCR = new OCR();
        imageOCR.convertOCR(imageInputname, OutputName);
    }
}
