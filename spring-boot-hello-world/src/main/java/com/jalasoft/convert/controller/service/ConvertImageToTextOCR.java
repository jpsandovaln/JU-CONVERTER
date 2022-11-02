package com.jalasoft.convert.controller.service;

import net.sourceforge.tess4j.TesseractException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.jalasoft.convert.model.coverters.OCR;

@Service
public class ConvertImageToTextOCR {
    private String pathOcr;
    public void convertImageToText(String imageInputname, String lang) throws TesseractException {
        OCR imageOCR = new OCR();
        List<String> params = new ArrayList<>();
        params.add(imageInputname);
        params.add(lang);
        imageOCR.extract(params);
        pathOcr = imageOCR.getPathOcr();
    }
    public String getPathOcr() {
        return pathOcr;
    }
}
