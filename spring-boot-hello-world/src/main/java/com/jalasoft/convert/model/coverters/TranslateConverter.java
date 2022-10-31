package com.jalasoft.convert.model.coverters;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class TranslateConverter implements Converter, ConverterConfiguration {
    private ConverterConfigurationValues configurationValues;

    @Override
    public void convert(InputStream inputStream, OutputStream outputStream){
        this.convert(inputStream, outputStream, configurationValues);
    }

    protected abstract void convert(InputStream inputStream, OutputStream outputStream, ConverterConfigurationValues configurationValues);

    @Override
    public void initializeConfiguration(ConverterConfigurationValues configurationValues) {
        this.configurationValues = configurationValues;
    }

}
