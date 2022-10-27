package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.controller.executor.Executor;
import com.jalasoft.convert.model.commandbuilder.CommandBuilder;
import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VideoCommandAdapterConvert extends VideoConvert {

    @Override
    protected void convert(InputStream inputStream, OutputStream outputStream, ConverterConfigurationValues configurationValues) throws IOException {
        VideoConverterConfigurationValues settings = (VideoConverterConfigurationValues) configurationValues;
        CommandBuilder builderCommand = new VideoCommand();
        builderCommand.setParameters(settings.parameters());
        Executor executor = new Executor();
        executor.runCommand(builderCommand.getCommand());
        String newFilePath = "Download\\" + settings.getNewName() + settings.getOutFormat();

        IOUtils.copy(new FileInputStream(newFilePath), outputStream);
    }
}
