package com.jalasoft.convert.controller.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.model.extractors.OCR;
@Service
public class ConvertImageToTextOCR {
    private String pathOcr;
    public void convertImageToText(String imageInputname, String lang) throws ExtractorException{
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
