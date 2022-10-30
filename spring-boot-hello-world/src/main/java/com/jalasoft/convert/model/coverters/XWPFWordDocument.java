package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.ConverterFileException;
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
public class XWPFWordDocument extends DocConvert {
    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws ConverterFileException {
        XWPFDocument document = null;
        PdfOptions pdfOptions = PdfOptions.create();
        try {
            document = new XWPFDocument(inputStream);
            PdfConverter.getInstance().convert(document, outputStream, pdfOptions);
            document.close();
        } catch (IOException e){
            throw new ConverterFileException(e.getMessage(),e);
        }
    }
}
