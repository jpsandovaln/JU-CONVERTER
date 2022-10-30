package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.exception.FileNotFoundException;
import com.jalasoft.convert.common.logger.At18Logger;
import org.apache.poi.EmptyFileException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * It is responsible to put a middelware between postman and ImageController
 *
 * Methods to use for HttpServletRequest req: https://docs.oracle.com/javaee/6/api/javax/servlet/ServletRequest.html#getParameterMap()
 * Methods to get the parameters of a file req.getPart("Key file"): https://tomcat.apache.org/tomcat-8.0-doc/api/org/apache/catalina/core/ApplicationPart.html
 *
 * @author Mauricio Aliendre
 * @version 1.0
 */
@WebFilter(urlPatterns = "/uploadImage")
public class ImageControllerMiddleware implements Filter{
    private static final Logger LOG = new At18Logger().getLogger();
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            if((req.getPart("file").getContentType().contains("image") && res.getStatus() == 200)){
                LOG.info(req.getPart("file").getContentType());
                LOG.info("Proccess Executed Sucessfully");
                chain.doFilter(request, response);
                LOG.info ("Response Status Code is: " + res.getStatus());
            } else {
                LOG.info("Status is not 200 or the file does not have content");
                throw new FileNotFoundException("Status is not 200 or the file does not have content");
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
