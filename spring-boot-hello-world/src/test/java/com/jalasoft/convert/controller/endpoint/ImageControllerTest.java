package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import java.io.File;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * It is responsible to test the ImageController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */


public class ImageControllerTest {

    @Test (expected = NullPointerException.class)
    public void shouldReturnExceptionWithNullValue(){
        ImageController ic = new ImageController();
        assertThat(ic.uploadImage("convert",null,"-colorspace", "10", "10","","ok","png").getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void shouldReturnBadRequestResponse(){
        ImageController ic = new ImageController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\image.jpg");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", byteFile);
        assertThat(ic.uploadImage("convert",mockMultipartFile,"-colorspace", "10", "10","","ok","png").getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
