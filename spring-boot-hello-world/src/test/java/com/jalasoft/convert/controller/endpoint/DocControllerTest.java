package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import java.io.File;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * It is responsible to test the DocController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */

public class DocControllerTest {
    @Test
    public void shouldReturnBadRequestResponse(){
        DocController dc = new DocController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\document.dock");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",byteFile);
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        assertThat(dc.readDoc(mockMultipartFile, rsp).getStatusCode().value()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test (expected = NullPointerException.class)
    public void shouldReturnNullPointerException(){
        DocController dc = new DocController();
        dc.readDoc(null, null);
    }
}
