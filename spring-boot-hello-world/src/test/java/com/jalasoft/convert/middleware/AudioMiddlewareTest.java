/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.middleware;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.*;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/**
 * It is responsible to test the AudioMiddleware Class, as it is being used Filters, it is necessary to mock the funcionality
 * of request, response and filterchain, Spring offers the "Mocks" of these three classes
 * @author Mauricio Aliendre
 * @version 1.0
 */
public class AudioMiddlewareTest{
    /**
     * This Test Case checks if the middleware and controller works correctly inlcuding the token
     */
    @Test
    public void testPositiveAudioControllerMiddleware() throws IOException, ServletException, NullPointerException{
        AudioControllerMiddleware audioControllerMiddleware = new AudioControllerMiddleware();
        String fileName = "song.mp3";
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\song.mp3");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName, "audio/mpeg", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("bitrate", "128k");
        req.addParameter("channels", "2");
        req.addParameter("sampling frequency", "44100");
        req.addParameter("format", "mp3");
        audioControllerMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("bitrate"), "128k");
        assertEquals(req.getParameter("channels"), "2");
        assertEquals(req.getParameter("sampling frequency"), "44100");
        assertNotEquals(req.getParameter("format"), "mp4");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checkS if the middleware and controller works correctly with a incorrect token number
     */
    @Test
    public void testNegativeAudioControllerMiddleware() throws IOException, ServletException, NullPointerException{
        AudioControllerMiddleware audioControllerMiddleware = new AudioControllerMiddleware();
        String fileName = "song.mp3";
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\song.mp3");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName, "audio/mpeg", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b5f6");
        req.addFile(mockMultipartFile);
        req.addParameter("bitrate", "128k");
        req.addParameter("channels", "2");
        req.addParameter("sampling frequency", "44100");
        req.addParameter("format", "mp3");
        audioControllerMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("bitrate"), "128k");
        assertEquals(req.getParameter("channels"), "2");
        assertEquals(req.getParameter("sampling frequency"), "44100");
        assertNotEquals(req.getParameter("format"), "mp4");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    /**
     * This Test Case checks if the middleware and controller works correctly with a empty field on parameters sended
     */
    @Test
    public void testNegativeAudioControllerMiddleware2() throws IOException, ServletException, NullPointerException{
        AudioControllerMiddleware audioControllerMiddleware = new AudioControllerMiddleware();
        String fileName = "song.mp3";
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\song.mp3");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName, "audio/mpeg", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("", "128k");
        req.addParameter("channels", "2");
        req.addParameter("sampling frequency", "44100");
        req.addParameter("format", "mp3");
        audioControllerMiddleware.doFilter(req, rsp, mockChain);

        assertNull(req.getParameter("bitrate"));
        assertEquals(req.getParameter("channels"), "2");
        assertEquals(req.getParameter("sampling frequency"), "44100");
        assertNotEquals(req.getParameter("format"), "mp4");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
