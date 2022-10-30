package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.ConverterFileException;

import java.io.InputStream;
import java.io.OutputStream;

public interface Converter {
    void convert(InputStream inputStream, OutputStream outputStream) throws ConverterFileException, ExecuteException;
}
