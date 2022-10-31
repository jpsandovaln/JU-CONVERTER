package com.jalasoft.convert.controller.endpoint;
import org.junit.Test;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class AudioControllerTest {

    //DirectoryNotEmptyException
    @Test
    public void shouldReturnAudioResponse() throws IOException {
        File file = new File("D:\\AutomationTesting\\Prog102\\gitRemote\\JU-CONVERTER\\Uploads\\audio.mp3");
        //MultipartFile mfile = new MockMultipartFile("file","audio.mp3","audio/plain", file);
        //MultipartFile multipartFile = null;
        AudioControllerr audioControllerr = new AudioControllerr();
        //System.out.println(audioControllerr.uploadAudio(multipartFile, "128k","2","44100","mp3"));
    }
}
