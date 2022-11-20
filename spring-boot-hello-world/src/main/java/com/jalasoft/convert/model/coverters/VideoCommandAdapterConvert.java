package com.jalasoft.convert.model.coverters;

import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.ConverterFileException;
import com.jalasoft.convert.model.executor.Executor;
import com.jalasoft.convert.model.commandbuilder.CommandBuilder;
import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class VideoCommandAdapterConvert extends VideoConvert {

    @Override
    protected void convert(InputStream inputStream, OutputStream outputStream, ConverterConfigurationValues configurationValues) throws ExecuteException, ConverterFileException {
        try {
            VideoConverterConfigurationValues settings = (VideoConverterConfigurationValues) configurationValues;
            CommandBuilder builderCommand = new VideoCommand();
            builderCommand.setParameters(settings.parameters());
            Executor executor = new Executor();
            executor.runCommand(builderCommand.getCommand());
            String newFilePath = System.getProperty("user.dir") + "/Download/" + settings.getNewName() + settings.getOutFormat();
            IOUtils.copy(new FileInputStream(newFilePath), outputStream);
        } catch (ExecuteException e) {
            throw new ExecuteException(e.getMessage());
        } catch (IOException e){
            throw new ConverterFileException(e.getMessage(),e);
        }
    }
}
