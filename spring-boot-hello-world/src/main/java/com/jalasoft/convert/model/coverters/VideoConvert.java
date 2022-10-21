package com.jalasoft.convert.model.coverters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class VideoConvert implements Converter, ConverterConfiguration {
    private ConverterConfigurationValues configurationValues;

    @Override
    public void convert(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.convert(inputStream, outputStream, configurationValues);
    }

    protected abstract void convert(InputStream inputStream, OutputStream outputStream, ConverterConfigurationValues configurationValues) throws IOException;

    @Override
    public void initializeConfiguration(ConverterConfigurationValues configurationValues) {
        this.configurationValues = configurationValues;
    }
}
