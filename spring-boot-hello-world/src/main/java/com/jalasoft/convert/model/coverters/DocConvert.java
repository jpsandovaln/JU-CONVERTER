package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.ConverterFileException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class DocConvert implements Converter {
    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws ConverterFileException {
        this.convert(inputStream, outputStream);
    }
}
