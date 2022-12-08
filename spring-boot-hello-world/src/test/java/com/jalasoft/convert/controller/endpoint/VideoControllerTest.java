package com.jalasoft.convert.controller.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import java.io.File;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * It is responsible to test the VideoController Class, this class works with Postman and receive all the parameters
 * to generate the request
 * @author Rodrigo Valda
 * @version 1.0
 */

public class VideoControllerTest {
    @Test
    public void shouldReturnBadRequestResponseVideoController(){
        VideoController vd = new VideoController();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\perrito.mp4");
        byte[] byteFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file",byteFile);
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        int value = vd.uploadVideo(mockMultipartFile, "hi",".wmv","1","0","2000","250","","","30","1","600x600","",rsp).getStatusCodeValue();
        assertEquals(value, 400);
    }
}
