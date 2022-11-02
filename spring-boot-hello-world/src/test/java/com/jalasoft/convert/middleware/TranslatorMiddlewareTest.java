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
 * It is responsible to test the TranslatorController Class, as it is being used Filters, it is necessary to mock the funcionality
 * of request, response and filterchain, Spring offers the "Mocks" of these three classes
 * @author Mauricio Aliendre
 * @version 1.0
 */
public class TranslatorMiddlewareTest {
    /**
     * This Test Case checks if the middleware and controller works correctly inlcuding the token and a txt file
     */
    @Test
    public void testPositiveTranlateControllerTxtMiddleware() throws IOException, ServletException, NullPointerException{
        TranslatorMiddleware translatorMiddleware = new TranslatorMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\Trouble.txt");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("langI", "en");
        req.addParameter("langO", "es");
        translatorMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("langI"), "en");
        assertEquals(req.getParameter("langO"), "es");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checks if the middleware and controller works correctly with a incorrect token number txt file
     */
    @Test
    public void testNegativeTranslateControllerTxtMiddleware() throws IOException, ServletException, NullPointerException{
        TranslatorMiddleware translatorMiddleware = new TranslatorMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\Trouble.txt");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b5f6");
        req.addFile(mockMultipartFile);
        req.addParameter("langI", "en");
        req.addParameter("langO", "es");
        translatorMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("langI"), "en");
        assertEquals(req.getParameter("langO"), "es");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checks if the middleware and controller works correctly inlcuding the token and a word file
     */
    @Test
    public void testPositiveTranlateControllerWordMiddleware() throws IOException, ServletException, NullPointerException{
        TranslatorMiddleware translatorMiddleware = new TranslatorMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\document.dock");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("langI", "en");
        req.addParameter("langO", "es");
        translatorMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("langI"), "en");
        assertEquals(req.getParameter("langO"), "es");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checks if the middleware and controller works correctly with a incorrect token number word file
     */
    @Test
    public void testNegativeTranslateControllerWordMiddleware() throws IOException, ServletException, NullPointerException{
        TranslatorMiddleware translatorMiddleware = new TranslatorMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\document.dock");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b5f6");
        req.addFile(mockMultipartFile);
        req.addParameter("langI", "en");
        req.addParameter("langO", "es");
        translatorMiddleware.doFilter(req, rsp, mockChain);

        assertEquals(req.getParameter("langI"), "en");
        assertEquals(req.getParameter("langO"), "es");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * This Test Case checks if the middleware and controller works correctly with a empty field on parameters sended
     */
    @Test (expected = NullPointerException.class)
    public void testNegativeTranlasteControllerMiddleware2() throws IOException, ServletException, NullPointerException{
        TranslatorMiddleware translatorMiddleware = new TranslatorMiddleware();
        File newFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\jalasoft\\convert\\middleware\\prooffiles\\Trouble.txt");
        byte[] bFile = new byte[(int) newFile.length()];
        MockMultipartFile mockMultipartFile = new MockMultipartFile("text", bFile);
        MockMultipartHttpServletRequest req = new  MockMultipartHttpServletRequest();
        MockHttpServletResponse rsp = new MockHttpServletResponse();
        MockFilterChain mockChain = new MockFilterChain();
        req.setMethod("POST");
        req.setContentType("multipart/form-data; boundary=<calculated when request is sent>");
        req.addHeader("Authorization", "Bearer 1667345126530-7cd1287d-e176-4a49-877d-039a5d51b545");
        req.addFile(mockMultipartFile);
        req.addParameter("", "en");
        req.addParameter("langO", "es");
        translatorMiddleware.doFilter(req, rsp, mockChain);

        assertNull(req.getParameter("lnagI"));
        assertEquals(req.getParameter("langO"), "es");
        assertThat(rsp.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
