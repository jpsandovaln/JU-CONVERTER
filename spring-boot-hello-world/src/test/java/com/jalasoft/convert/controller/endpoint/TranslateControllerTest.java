package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockMultipartFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.File;
import java.io.IOException;


/**
 * It is responsible to test the TranslateController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */


public class TranslateControllerTest {
    @Test
    public void shouldExecuteTranslateControllerAndThrowBadRequest() throws IOException {
        TranslateController tr = new TranslateController();
        File testFile = new File("java/com/jalasoft/convert/middleware/prooffiles/Trouble.txt");
        byte[] byteFile = new byte[(int) testFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text",byteFile);
        assertThat(tr.translateGtTxt(mockMultipartFile,"en","es").getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}

