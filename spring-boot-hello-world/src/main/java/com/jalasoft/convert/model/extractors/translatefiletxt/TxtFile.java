/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.extractors.translatefiletxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.JOptionPane;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.common.exception.ReadFileException;
import com.jalasoft.convert.model.extractors.Extractor;

/**
 * It is responsible for using the Google Translate API to translate a text document.
 * @author Sarai Alvarez
 * @version 1.0
 */
public class TxtFile extends Extractor{

    public static String textToTranslate;
    public static File file;
    public static String[] name;
    private static String newPath;
    private static Gt_Translate g;

    //to get from the path the name of the file plus its extension (file.txt)
    public static void getFileName() {

        String nameFile = file.getAbsolutePath(); // save as string the path of the file
        name = nameFile.split("\\\\"); // we get only the name of the txt from the path.
    }

    //to translate the word "translated" which is added to the new generated txt, and rename the new document
    public static void translateWord(String languageInput, String languageOuput) {
        g = Gt_Translate.getInstance();
        String titleDocument = "Translated-"; // word to be added to the name of the new text file containing the translated text.
        try {
            String translateTitle = g.translateText(titleDocument, languageInput, languageOuput);
            writeee(translateTitle + name[name.length - 1], languageInput, languageOuput); //name of the generated txt file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //code to create the new file and write the translation into it
    public static void writeee(String name, String languageInput, String languageOutput) {
        File newFile;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        try {
            newFile = new File("Download\\" + name);
            fileWriter = new FileWriter(newFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.write(g.translateText(textToTranslate, languageInput, languageOutput)); //translation with Gtranslate
            newPath = newFile.toPath().toString();

            printWriter.close();
            bufferedWriter.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred" + e);
        }
    }

    public String getNewPath() {
        return newPath;
    }

    @Override
    public void extract(List<String> params) throws ExtractorException, ReadFileException {
        try {
            file = new File(params.get(0));
            String content = ReadTextFile.readFile(file, StandardCharsets.UTF_8); // Read the file
            textToTranslate = content;// we get the text that the ReadFile class outputs and save it in a new String txt
            getFileName();
            translateWord(params.get(1), params.get(2));
        } catch (IOException e) {
            throw new ExtractorException("Read text ", e);
        } catch (ReadFileException e) {
            throw new ReadFileException(e.getMessage(), e);
        }
    }
}
