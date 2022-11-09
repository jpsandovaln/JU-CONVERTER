/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.service;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.model.extractors.OCR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * It is responsible for receive the Image file with text and extract the OCR of it in another file.
 *
 * @author Hugo Solares
 * @version 1.0
 */
@Service
public class ConvertImageToTextOCR {
    private String pathOcr;

    public void convertImageToText(String imageInputName, String lang) throws ExtractorException {
        OCR imageOCR = new OCR();
        List<String> params = new ArrayList<>();
        params.add(imageInputName);
        params.add(lang);
        imageOCR.extract(params);
        pathOcr = imageOCR.getPathOcr();
    }

    public String getPathOcr() {
        return pathOcr;
    }
}
