package com.jalasoft.convert;
//copyright...
//author
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCR {
    public static void main(String[] args) {
        ITesseract image = new Tesseract();
        image.setDatapath("tessdata");
        try {
            String str = image.doOCR(new File("Uploads\\imagetest.jpeg"));
            System.out.println("Test from image is: ");
            System.out.println();
            System.out.println(str);
        } catch (TesseractException e) {
            System.out.println("Exception details: "+ e.getMessage());
        }
    }
}