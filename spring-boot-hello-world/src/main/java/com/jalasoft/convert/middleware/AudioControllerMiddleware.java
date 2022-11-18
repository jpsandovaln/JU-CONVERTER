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
import com.jalasoft.convert.model.mysqlmodel.TokenDB;
import com.jalasoft.convert.services.TokenService;
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

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private TokenService tokenService;
    /**
     * This is the Filter to receive the request which contains what a user sends from Postman
     * and response, the main idea is to manage exceptions before going through the controllers
     * in this case this is the filter for AudioController
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Logger LOG = new At18Logger().getLogger();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            List<Integer> IdToken = new ArrayList<>();
            List<String> tokens = new ArrayList<>();
            List<Integer> uses = new ArrayList<>();
            tokenService.getList().forEach((TokenDB token) -> {
                if(req.getHeader("Authorization").contains(token.getToken())){
                    IdToken.add(token.getId());
                } else {
                    LOG.info("The id does not match");
                }
            });
            tokenService.getList().forEach((TokenDB token) -> {
                if(req.getHeader("Authorization").contains(token.getToken())){
                    tokens.add(token.getToken());
                } else {
                    LOG.info("The token does not match");
                }
            });
            tokenService.getList().forEach((TokenDB token) -> {
                if(req.getHeader("Authorization").contains(token.getToken())){
                    uses.add(token.getUses());
                } else {
                    LOG.info("The token uses does not match");
                }
            });
            try {
                LOG.info("Remaining token uses: " + uses.get(0));
                    if (uses.get(0) >= 1 && req.getHeader("Authorization").length() == 57) {
                        try {
                            tokenService.getList().forEach((TokenDB token) -> {
                                    if (req.getHeader("Authorization").contains(token.getToken()) && uses.get(0) >= 1) {
                                        tokenService.updateUser(token.getId());
                                        System.out.println(token.getUses());
                                    } else {
                                        LOG.info("Token does not match or does not have more uses");
                                    }
                                });
                            if (res.getStatus() == 200) {
                                LOG.info("Proccess Executed Sucessfully");
                                chain.doFilter(request, response);
                                LOG.info("Response Status Code is: " + res.getStatus());
                            } else {
                                LOG.info("Status is not 200 or the file has a incorrect format");
                                throw new MiddlewareException("Status is not 200 or the file has a incorrect format");
                            }
                        } catch (MiddlewareException e){
                            throw new RuntimeException(e.getMessage());
                        }
                    } else if (uses.get(0) == 0) {
                        tokenService.delete(IdToken.get(0));
                        throw new MiddlewareException("Token has no more uses, please request another one");
                    } else {
                        LOG.info("Remaining token uses: " + uses.get(0));
                        LOG.info("Token was not introduced correctly");
                        throw new MiddlewareException("Remaining token uses: " + uses.get(0) + ", Token was not introduced correctly");
                    }
            } catch (RuntimeException e) {
                LOG.info("Number of token uses exhausted");
                LOG.info("Please request another Token to keep using the service");
                throw new RuntimeException("Number of token uses exhausted, Please request another Token to keep using the service", e);
            } catch (MiddlewareException e){
                throw new RuntimeException(e.getMessage());
            }
        } catch (RuntimeException e){
            throw new RuntimeException("The porcess could not be completed");
        }
    }
}
