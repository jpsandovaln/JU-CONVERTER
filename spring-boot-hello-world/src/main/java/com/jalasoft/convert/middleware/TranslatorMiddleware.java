/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.logger.At18Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * It is responsible to put a middelware between postman and TranslatorController
 *
 * Methods to use for HttpServletRequest req: https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterMap()
 * Methods to get the parameters of a file req.getPart("Key file"): https://tomcat.apache.org/tomcat-8.0-doc/api/org/apache/catalina/core/ApplicationPart.html
 *
 * @author Mauricio Aliendre
 * @version 1.0
 */
@WebFilter(urlPatterns = "/uploadGText/*")
public class TranslatorMiddleware implements Filter {
    private static final Logger LOG = new At18Logger().getLogger();
    /**
     * This is the Filter to receive the request which contains what a user sends from Postman
     * and response, the main idea is to manage exceptions before going through the controllers
     * in this case this is the filter for TranslatorController
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            if(((req.getParameter("langI").length() == 2) && req.getParameter("langO").length() == 2) && (req.getPart("text").getContentType().contains("text") || req.getPart("text").getContentType().contains("word"))){
                LOG.info("Proccess Executed Sucessfully");
                LOG.info(req.getPart("text").getContentType());
                chain.doFilter(request, response);
                LOG.info ("Response Status Code is " + res.getStatus());
            } else {
                LOG.info("The language is incorrect or the file does not contain a .txt or .dock file");
                throw new FileNotFoundException("The language is incorrect or the file does not contain a .txt or .dock file");
            }
        } catch (InstantiationError ie){
            LOG.info("Catch Instantiation Error: " + ie);
            ie.printStackTrace();
        } catch (NullPointerException nulle){
            LOG.info("Catch a null pointer exception: " + nulle);
            nulle.printStackTrace();
        }
    }
}
