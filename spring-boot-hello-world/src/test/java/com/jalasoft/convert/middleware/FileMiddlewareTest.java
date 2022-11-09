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

/**
 * It is responsible to test the FileController Class, as it is being used Filters, it is necessary to mock the funcionality
 * of request, response and filterchain, Spring offers the "Mocks" of these three classes
 * @author Mauricio Aliendre
 * @version 1.0
 */
public class FileMiddlewareTest {
    /**
     * This Test Case checks if the middleware and controller works correctly with a normal DocFile
     */
    @Test
    public void testPositiveFileControllerMiddleware() throws IOException, ServletException, NullPointerException{
        FileControllerMiddleware fileControllerMiddleware = new FileControllerMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\document.dock");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addFile(mockMultipartFile);
        fileControllerMiddleware.doFilter(req, rsp, mockChain);
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checkS if the middleware and controller works correctly with a Internal Server Error
     */
    @Test (expected = RuntimeException.class)
    public void testNegativeFileControllerMiddleware() throws IOException, ServletException, NullPointerException{
        FileControllerMiddleware fileControllerMiddleware = new FileControllerMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\document.dock");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        rsp.setStatus(500);
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addFile(mockMultipartFile);
        fileControllerMiddleware.doFilter(req, rsp, mockChain);
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
