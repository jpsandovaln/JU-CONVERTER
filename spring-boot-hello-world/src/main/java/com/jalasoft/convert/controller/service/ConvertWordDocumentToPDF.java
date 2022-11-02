/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.service;

import com.jalasoft.convert.common.exception.ConverterFileException;
import com.jalasoft.convert.model.coverters.DocConvert;
import com.jalasoft.convert.model.coverters.XWPFWordDocument;
import org.springframework.stereotype.Service;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * It is responsible for receive the word document (docx) and write this in other file.
 *
 * @author Maria Hurtado
 * @version 1.0
 */
@Service
public class ConvertWordDocumentToPDF {
    public void convertWordDocument(InputStream documentInputStream, OutputStream outputStream) throws ConverterFileException {
        DocConvert docConvert = new XWPFWordDocument();
        try {
            docConvert.convert(documentInputStream, outputStream);
        } catch (ConverterFileException e) {
            throw new ConverterFileException(e.getMessage());
        }
    }
}
