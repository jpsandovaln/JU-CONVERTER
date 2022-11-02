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
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/**
 * It is responsible to test the VideoController Class, as it is being used Filters, it is necessary to mock the funcionality
 * of request, response and filterchain, Spring offers the "Mocks" of these three classes
 * @author Mauricio Aliendre
 * @version 1.0
 */
public class VideoMiddlewareTest {
    /**
     * This Test Case checks if the middleware and controller works correctly inlcuding the token and a video
     */
    @Test
    public void testPositiveVideoControllerMiddleware() throws IOException, ServletException, NullPointerException{
        VideoControllerMiddleware videoControllerMiddleware = new VideoControllerMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\perrito.mp4");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("outName", "Hi");
        req.addParameter("outFormat", ".wmv");
        req.addParameter("volume", "1");
        req.addParameter("removeAudio", "0");
        req.addParameter("videoBitrate", "2000");
        req.addParameter("audioBitrate", "250");
        req.addParameter("videoFragment", "");
        req.addParameter("rotate", "");
        req.addParameter("fps", "30");
        req.addParameter("color", "1");
        req.addParameter("size", "600x600");
        req.addParameter("cropVideo", "");
        videoControllerMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("outName"), "Hi");
        assertEquals(req.getParameter("outFormat"), ".wmv");
        assertEquals(req.getParameter("volume"), "1");
        assertEquals(req.getParameter("removeAudio"), "0");
        assertEquals(req.getParameter("videoBitrate"), "2000");
        assertEquals(req.getParameter("audioBitrate"), "250");
        assertEquals(req.getParameter("videoFragment"), "");
        assertEquals(req.getParameter("rotate"), "");
        assertEquals(req.getParameter("fps"), "30");
        assertEquals(req.getParameter("color"), "1");
        assertEquals(req.getParameter("size"), "600x600");
        assertEquals(req.getParameter("cropVideo"), "");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checkS if the middleware and controller works correctly with a incorrect token number
     */
    @Test
    public void testNegativeVideoControllerMiddleware() throws IOException, ServletException, NullPointerException{
        VideoControllerMiddleware videoControllerMiddleware = new VideoControllerMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\perrito.mp4");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b5f6");
        req.addFile(mockMultipartFile);
        req.addParameter("outName", "Hi");
        req.addParameter("outFormat", ".wmv");
        req.addParameter("volume", "1");
        req.addParameter("removeAudio", "0");
        req.addParameter("videoBitrate", "2000");
        req.addParameter("audioBitrate", "250");
        req.addParameter("videoFragment", "");
        req.addParameter("rotate", "");
        req.addParameter("fps", "30");
        req.addParameter("color", "1");
        req.addParameter("size", "600x600");
        req.addParameter("cropVideo", "");
        videoControllerMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("outName"), "Hi");
        assertEquals(req.getParameter("outFormat"), ".wmv");
        assertEquals(req.getParameter("volume"), "1");
        assertEquals(req.getParameter("removeAudio"), "0");
        assertEquals(req.getParameter("videoBitrate"), "2000");
        assertEquals(req.getParameter("audioBitrate"), "250");
        assertEquals(req.getParameter("videoFragment"), "");
        assertEquals(req.getParameter("rotate"), "");
        assertEquals(req.getParameter("fps"), "30");
        assertEquals(req.getParameter("color"), "1");
        assertEquals(req.getParameter("size"), "600x600");
        assertEquals(req.getParameter("cropVideo"), "");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    /**
     * This Test Case checks if the middleware and controller works correctly with a empty field on parameters sended
     */
    @Test
    public void testNegativeVideoControllerMiddleware2() throws IOException, ServletException, NullPointerException{
        VideoControllerMiddleware videoControllerMiddleware = new VideoControllerMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\perrito.mp4");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("", "Hi");
        req.addParameter("outFormat", ".wmv");
        req.addParameter("volume", "1");
        req.addParameter("removeAudio", "0");
        req.addParameter("videoBitrate", "2000");
        req.addParameter("audioBitrate", "250");
        req.addParameter("videoFragment", "");
        req.addParameter("rotate", "");
        req.addParameter("fps", "30");
        req.addParameter("color", "1");
        req.addParameter("size", "600x600");
        req.addParameter("cropVideo", "");
        videoControllerMiddleware.doFilter(req, rsp, mockChain);

        assertNull(req.getParameter("outName"));
        assertEquals(req.getParameter("outFormat"), ".wmv");
        assertEquals(req.getParameter("volume"), "1");
        assertEquals(req.getParameter("removeAudio"), "0");
        assertEquals(req.getParameter("videoBitrate"), "2000");
        assertEquals(req.getParameter("audioBitrate"), "250");
        assertEquals(req.getParameter("videoFragment"), "");
        assertEquals(req.getParameter("rotate"), "");
        assertEquals(req.getParameter("fps"), "30");
        assertEquals(req.getParameter("color"), "1");
        assertEquals(req.getParameter("size"), "600x600");
        assertEquals(req.getParameter("cropVideo"), "");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
