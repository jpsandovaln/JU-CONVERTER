/*
 * Copyright (c) 2022 Jala University.
 * <p> * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.model.translatefiletxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

/*
 * It is responsible for using the Google Translate API to translate a text document.
 * @author Sarai Alvarez
 * @version 1.0
 */
public class TxtFile {

    public static String textToTranslate;
    public static File file;
    public static String[] name;
    private static String newPath;
    private static Gt_Translate g;

    //to get from the path the name of the file plus its extension (file.txt)
    public static void getFileName() {

        String namefile = file.getAbsolutePath(); // save as string the path of the file
        String separator = "\\\\";
        name = namefile.split(separator); // we get only the name of the txt from the path.
    }

    //to translate the word "translated" which is added to the new generated txt, and rename the new document
    public static void translateWord(String languageInput, String languageOuput) {
        g = Gt_Translate.getInstance();
        String titleDocument = "Traducido - "; // word to be added to the name of the new text file containing the translated text.
        //for the name of the new txt the word "translated" is translated into the selected language
        String translateTitle;
        try {
            //traducireltituloalidiomaselect = g.translateText(tituloDocumento,"en","fr");
            translateTitle = g.translateText(titleDocument, languageInput, languageOuput);
            writeee(translateTitle + name[name.length - 1], languageInput, languageOuput); //name of the generated txt file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //code to create the new file and write the translation to it
    public static void writeee(String name, String languageInput, String languageOuput) {
        File newfile;
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter;
        try {
            newfile = new File(name);
            fileWriter = new FileWriter(newfile);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.write(g.translateText(textToTranslate, languageInput, languageOuput));
            newPath = newfile.toPath().toString();

            printWriter.close();
            bufferedWriter.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error has occurred" + e);
        }
    }

    public void getPath(String path, String languageInput, String languageOuput) {
        // We get the path of the txt file
        file = new File(path);
        String content = null;
        try {
            content = ReadTextFile.readFile(file, StandardCharsets.UTF_8); // Read the file
        } catch (IOException e) {
            e.printStackTrace();
        }

        textToTranslate = content;// we get the text that the ReadFile class outputs and save it in a new String txt
        getFileName();
        translateWord(languageInput, languageOuput);
    }

    public String getNewPath() {
        return newPath;
    }
}
