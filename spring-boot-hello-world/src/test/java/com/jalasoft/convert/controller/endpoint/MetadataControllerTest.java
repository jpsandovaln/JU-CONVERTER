package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * It is responsible to test the MetadataController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */


public class MetadataControllerTest {
    @Test
    public void shouldReturnBadRequestResponse(){
        MetadataController md = new MetadataController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\image.jpg");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",byteFile);
        String value = md.uploadMetadata(mockMultipartFile, "txt").getStatus();
        assertThat(Integer.parseInt(value)).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
