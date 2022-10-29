package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.InvalidFileException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class DocConvert implements Converter {
    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws InvalidFileException {
        this.convert(inputStream, outputStream);
    }
}
