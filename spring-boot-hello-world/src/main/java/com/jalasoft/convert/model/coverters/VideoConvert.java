package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.ExecuteException;
<<<<<<< HEAD
import com.jalasoft.convert.common.exception.InvalidFileException;
=======
import com.jalasoft.convert.common.exception.ConverterFileException;

>>>>>>> 02bc9be (Added some Responses with exceptions)
import java.io.InputStream;
import java.io.OutputStream;

public abstract class VideoConvert implements Converter, ConverterConfiguration {
    private ConverterConfigurationValues configurationValues;

    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws ExecuteException, ConverterFileException {
        this.convert(inputStream, outputStream, configurationValues);
    }

    protected abstract void convert(InputStream inputStream, OutputStream outputStream, ConverterConfigurationValues configurationValues) throws ExecuteException, ConverterFileException;

    @Override
    public void initializeConfiguration(ConverterConfigurationValues configurationValues) {
        this.configurationValues = configurationValues;
    }
}
