/*
 * Copyright (c) 2022 Jala University.
 * <p> * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.model.translatefiletxt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * It is responsible for using the Google Translate API to translate a text document.
 * @author Sarai Alvarez
 * @version 1.0
 */
public class ReadTextFile {

    // open the original text file to be translated and extract the content, read the content.
    /*
        The following code reads raw byte streams using FileInputStream
        and decodes them into characters using a specific character set using
        an InputStreamReader forms a string using a line separator.  
    */

    public static String readFile(File file, Charset encoding) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileInputStream fileStream = new FileInputStream(file);
        BufferedReader br;
        String line;
        br = new BufferedReader(new InputStreamReader(fileStream, encoding));
        while ((line = br.readLine()) != null) {
            sb.append(line + System.lineSeparator());
        }
        br.close();
        return sb.toString();
    }
}
