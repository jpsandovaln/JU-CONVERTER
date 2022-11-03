package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * It is responsible to test the OcrController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */


public class OcrControllerTest {
    @Test (expected = NullPointerException.class)
    public void shouldReturnNullPointerException(){
        OcrController oc = new OcrController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\ocrImage.png");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",byteFile);
        oc.OCRExtract(mockMultipartFile, "eng");
    }

    @Test
    public void shouldReturnBadRequestResponse(){
        OcrController oc = new OcrController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\ocrImage.png");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("img",byteFile);
        assertThat(oc.OCRExtract(mockMultipartFile, "eng").getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
