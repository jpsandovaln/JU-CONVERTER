package com.jalasoft.convert.model.docconvert;

import com.jalasoft.convert.model.docconvert.DocConvert;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * It is responsable for convert the word document (docx) to PDF
 *
 * @author Maria Hurtado
 * @version 1.0
 */
public class XWPFWordDocument implements DocConvert {
    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws IOException {
        XWPFDocument document = new XWPFDocument(inputStream);
        PdfOptions pdfOptions = PdfOptions.create();
        PdfConverter.getInstance().convert(document, outputStream, pdfOptions);
        document.close();
    }
}
