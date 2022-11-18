/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.exception.MiddlewareException;
import com.jalasoft.convert.common.logger.At18Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * It is responsible to put a middelware between postman and FileController
 *
 * Methods to use for HttpServletRequest req: https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterMap()
 * Methods to get the parameters of a file req.getPart("Key file"): https://tomcat.apache.org/tomcat-8.0-doc/api/org/apache/catalina/core/ApplicationPart.html
 *
 * @author Mauricio Aliendre
 * @version 1.0
 */
@WebFilter(urlPatterns = "/uploadFile")
public class FileControllerMiddleware implements Filter{
    /**
     * This is the Filter to receive the request which contains what a user sends from Postman
     * and response, the main idea is to manage exceptions before going through the controllers
     * in this case this is the filter for FileController
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        Logger LOG = new At18Logger().getLogger();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            if(res.getStatus() == 200){
                LOG.info("Proccess Executed Sucessfully");
                chain.doFilter(request, response);
                LOG.info ("Response Status Code is: " + res.getStatus());
            } else {
                LOG.info("Status is not 200 or the file does not have content");
                throw new MiddlewareException("Status is not 200 or the file does not have content");
            }
        }catch (NullPointerException e) {
            LOG.info("The File is empty");
            throw new NullPointerException("The file is empty");
        } catch (MiddlewareException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
