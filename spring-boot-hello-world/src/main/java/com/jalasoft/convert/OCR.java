/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * It is responsible for uploading Audios and converting them
 *
 * @author Hugo Solares
 * @version 1.0
 */
public class OCR {
    public static void main(String[] args) {
        ITesseract image = new Tesseract();
        image.setDatapath("tessdata");
        try {
            String str = image.doOCR(new File("Uploads\\imagenow.png"));
            System.out.println("Test from image is: ");
            System.out.println();
            System.out.println(str);
        } catch (TesseractException e) {
            System.out.println("Exception details: "+ e.getMessage());
        }
    }
}