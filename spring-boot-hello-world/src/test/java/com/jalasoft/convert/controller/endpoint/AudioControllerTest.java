package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AudioControllerTest {

    /**
     * It is responsible to test the AudioController Class, this class works with Postman and receive all the parameters
     * to generate the request
     * @author Rodrigo Valda
     * @version 1.0
     */
    @Test
    public void shouldReturnAudioResponseWithBadRequest() throws IOException {
        AudioController ac = new AudioController();
        String fileName = "song.mp3";
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\song.mp3");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName, "audio/mpeg", byteFile);
        assertThat(ac.uploadAudio(mockMultipartFile,"128k","2","44100",",mp3").getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test (expected = NullPointerException.class)
    public void shouldReturnNullPointerException() throws IOException {
        AudioController ac = new AudioController();
        String fileName = "song.mp3";
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\song.mp3");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", null, "audio/mpeg", byteFile);
        ac.uploadAudio(null,null,null,null,null);
    }
}
