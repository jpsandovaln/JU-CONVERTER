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
import javax.servlet.*;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * It is responsible to put a middelware between postman and audiocontroller
 *
 * Methods to use for HttpServletRequest req: https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterMap()
 * Methods to get the parameters of a file req.getPart("Key file"): https://tomcat.apache.org/tomcat-8.0-doc/api/org/apache/catalina/core/ApplicationPart.html
 *
 * @author Mauricio Aliendre
 * @version 1.0
 */
@WebFilter(urlPatterns = "/uploadAudio")
public class AudioControllerMiddleware implements Filter{
    private static final Logger LOG = new At18Logger().getLogger();
    /**
     * This is the Filter to receive the request which contains what a user sends from Postman
     * and response, the main idea is to manage exceptions before going through the controllers
     * in this case this is the filter for AudioController
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = System.getProperty("user.dir") + "\\spring-boot-hello-world\\src\\main\\java\\com\\jalasoft\\convert\\middleware\\token\\token.txt";
        File fileToken = new File(path);
        Scanner myReader = new Scanner(fileToken);
        String token = myReader.nextLine();
        int tokenCounter = Integer.parseInt(myReader.nextLine());
        LOG.info("Remaining token uses: " + tokenCounter);
        try {
            if (req.getHeader("Authorization").contains(token) && tokenCounter >= 1) {
                FileWriter fw = new FileWriter(path, false);
                tokenCounter -= 1;
                LOG.info("Remaining token uses: " + String.valueOf(tokenCounter));
                fw.write(token);
                fw.write(System.getProperty("line.separator"));
                fw.write(Integer.toString(tokenCounter));
                fw.close();
                myReader.close();
                if (req.getPart("file").getContentType().contains("audio") && res.getStatus() == 200) {
                    LOG.info("Proccess Executed Sucessfully");
                    chain.doFilter(request, response);
                    LOG.info("Response Status Code is: " + res.getStatus());
                } else {
                    LOG.info("Status is not 200 or the file has a incorrect format");
                    throw new MiddlewareException("Status is not 200 or the file has a incorrect format");
                }
            } else if (tokenCounter < 1) {
                LOG.info("Token has no more uses, please request another one");
                FileWriter fw = new FileWriter(path, false);
                PrintWriter pw = new PrintWriter(fw, false);
                pw.flush();
                pw.close();
                fw.close();
                throw new MiddlewareException("Token has no more uses, please request another one");
            }
            else {
                LOG.info("Token was not introduced correctly");
                throw new MiddlewareException("Token was not introduced correctly");
            }
        } catch (MiddlewareException e){
            PrintWriter out = res.getWriter();
            out.println("Remaining token uses: " + tokenCounter);
            out.println(e.getMessage());
        }
    }
}
