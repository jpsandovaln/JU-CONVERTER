package com.jalasoft.convert.model.docconvert;

import com.jalasoft.convert.model.coverters.Converter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class DocConvert implements Converter {
    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.convert(inputStream, outputStream);
    }
}
