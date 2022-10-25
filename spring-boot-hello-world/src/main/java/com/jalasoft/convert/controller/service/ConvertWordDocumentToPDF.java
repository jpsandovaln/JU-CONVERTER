package com.jalasoft.convert.controller.service;

import com.jalasoft.convert.model.docconvert.DocConvert;
import com.jalasoft.convert.model.docconvert.XWPFWordDocument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * It is responsable for receive the word document (docx) and write this in other file.
 *
 * @author Maria Hurtado
 * @version 1.0
 */
@Service
public class ConvertWordDocumentToPDF {
    public void convertWordDocument(InputStream documentInputStream, OutputStream outputStream) throws IOException {
        DocConvert docConvert = new XWPFWordDocument();
        docConvert.convert(documentInputStream, outputStream);
    }
}
