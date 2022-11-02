/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.extractors;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.common.logger.At18Logger;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

/**
 * It is responsible for reading images and converting them to text
 *
 * @author Hugo Solares
 * @version 1.0
 */
public class OCR extends Extractor {
    private static final Logger LOG = new At18Logger().getLogger();
    private String pathOcr;

    @Override
    public void extract(List<String> params) throws ExtractorException {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata");
        tesseract.setLanguage(params.get(1));
        String imageInputName = params.get(0);
        String[] outputName = imageInputName.split("\\.");
        try {
            String strOutput = tesseract.doOCR(new File("Uploads\\" + imageInputName));
            LOG.info("Test from image is: \n" + strOutput);
            FileUtils.writeStringToFile(new File("Download\\" + outputName[0] + ".txt"), strOutput, StandardCharsets.UTF_8);
            pathOcr = "Download\\" + outputName[0] + ".txt";
        } catch (TesseractException e) {
            throw new ExtractorException("Error during processing OCR", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPathOcr() {
        return pathOcr;
    }
}