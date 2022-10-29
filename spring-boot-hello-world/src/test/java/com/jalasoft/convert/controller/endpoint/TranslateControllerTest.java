package com.jalasoft.convert.controller.endpoint;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.http.HttpEntity;



public class TranslateControllerTest {
    @Test
    public void shouldExecuteTranslateController() throws IOException {

        Path path = Paths.get("Uploads\\testText.txt");
        String name = "data";
        String originalFileName = "testText.txt";
        String contentType = "text/plain";
        byte[] content = "Hello goodevenning, I am working on the unit tests".getBytes();
        MultipartFile result = new MockMultipartFile(name,
                originalFileName, contentType, content);
        TranslateController tr = new TranslateController();
        //tr.translateGt(result,"en","es");
        //assertEquals("textTet", tr.translateGt(result,"en","es");)
    }
}

