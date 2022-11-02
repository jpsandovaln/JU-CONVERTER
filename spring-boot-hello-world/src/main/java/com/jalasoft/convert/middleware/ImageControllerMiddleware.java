package com.jalasoft.convert.middleware;

import com.jalasoft.convert.common.exception.FileNotFoundException;
import com.jalasoft.convert.common.logger.At18Logger;

import javax.servlet.*;
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
        String path = System.getProperty("user.dir") + "\\spring-boot-hello-world\\src\\main\\java\\com\\jalasoft\\convert\\middleware\\token\\token.txt";
        File fileToken = new File(path);
        Scanner myReader = new Scanner(fileToken);
        String token = myReader.nextLine();
        int tokenCounter = Integer.parseInt(myReader.nextLine());
        if (req.getHeader("Authorization").contains(token) && tokenCounter >= 1) {
            FileWriter fw = new FileWriter(path, false);
            tokenCounter -= 1;
            LOG.info("Remaining token uses: " + String.valueOf(tokenCounter));
            fw.write(token);
            fw.write(System.getProperty("line.separator"));
            fw.write(Integer.toString(tokenCounter));
            fw.close();
            myReader.close();
            if((req.getPart("file").getContentType().contains("image") && res.getStatus() == 200)){
                LOG.info(req.getPart("file").getContentType());
                LOG.info("Proccess Executed Sucessfully");
                chain.doFilter(request, response);
                LOG.info ("Response Status Code is: " + res.getStatus());
            } else {
                LOG.info("Status is not 200 or the file does not have content");
                try {
                    throw new FileNotFoundException("Status is not 200 or the file does not have content");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (tokenCounter < 1) {
            LOG.info("Token has no more uses, please request another one");
            FileWriter fw = new FileWriter(path, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }
        else {
            LOG.info("Token was not introduced correctly");
            try {
                throw new FileNotFoundException("Token was not introduced correctly");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
