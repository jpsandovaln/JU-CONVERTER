package com.jalasoft.convert.model.converters;

import com.jalasoft.convert.common.exception.ConverterFileException;
import com.jalasoft.convert.common.exception.ExecuteException;
import com.jalasoft.convert.common.exception.FileStorageException;
import com.jalasoft.convert.controller.service.FileStorageService;
import com.jalasoft.convert.model.coverters.VideoCommandAdapterConvert;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;


public class VideoCommandAdapterConvertTest {
    /**
     * ThiS unit test is not still workin, it is necessary add multipartfile
     */
    /*@Test
    public void shouldConvertFilesExecutingVideoCommand() throws FileStorageException, ExecuteException, ConverterFileException {
        VideoCommandAdapterConvert video = new VideoCommandAdapterConvert();
        video.convert(InputStream.nullInputStream(), OutputStream.nullOutputStream());
    }*/

}
