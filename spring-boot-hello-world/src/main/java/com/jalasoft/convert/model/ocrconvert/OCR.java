/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.ocrconvert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * It is responsible for reading images and converting them to text
 *
 * @author Hugo Solares
 * @version 1.0
 */
public class OCR {
    private String pathOcr;
    public void convertOCR(String imageInputName, String lang) {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata");
        tesseract.setLanguage(lang);
        String[] outputName = imageInputName.split("\\.");
        try {
            String strOutput = tesseract.doOCR(new File("Uploads\\" + imageInputName));
            System.out.println("Test from image is: ");
            System.out.println();
            System.out.println(strOutput);
            FileUtils.writeStringToFile(new File("Downloads\\" + outputName[0] + ".txt"), strOutput, StandardCharsets.UTF_8);
            pathOcr="Downloads\\" + outputName[0] + ".txt";
        } catch (TesseractException e) {
            System.out.println("Exception details: "+ e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getPathOcr() {
        return pathOcr;
    }
}