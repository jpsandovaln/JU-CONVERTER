package com.jalasoft.convert.model.translateconvert;

import com.jalasoft.convert.model.coverters.Converter;
import com.jalasoft.convert.model.coverters.ConverterConfiguration;
import com.jalasoft.convert.model.coverters.ConverterConfigurationValues;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class TranslateConverter implements Converter, ConverterConfiguration {
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
