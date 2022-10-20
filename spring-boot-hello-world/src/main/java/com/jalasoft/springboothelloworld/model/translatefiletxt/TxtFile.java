package com.jalasoft.springboothelloworld.model.translatefiletxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class TxtFile {

    private static Gt_Translate g;
    public static String txt;
    public static File file;
    public static String[] name ;
        public static void main(String args[]) throws Exception {
            GetPath("D:\\jala\\progra102\\proyectoprogra102\\archivo de texto\\prueba.txt", "en", "de");
        }
        public static void GetPath(String path, String languageE, String languageS) {
            // We get the path of the txt file
            //file = new File("D:\\jala\\progra102\\proyectoprogra102\\archivo de texto\\prueba.txt");
            file = new File(path);

            String content = null;
            try {
                content = ReadTextFile.readFile(file, StandardCharsets.UTF_8);// lee el archivo
            } catch (IOException e) {
                e.printStackTrace();
            }

            txt =  content;// we get the text that the ReadFile class outputs and save it in a new String txt
            obtenerNombreDelArchivo();
            traducirPalabra(languageE,languageS);
        }

        //to get from the path the name of the file plus its extension (file.txt)
        public static void obtenerNombreDelArchivo(){

            String namefile = file.getAbsolutePath();// save as string the path of the file
            String separator = "\\\\";
            name = namefile.split(separator);// we get only the name of the txt from the path.    
        }

        //to translate the word "translated" which is added to the new generated txt, and rename the new document
        public static void traducirPalabra(String languageE, String languageS){
            g = Gt_Translate.getInstance();
            String tituloDocumento = "Traducido - ";// word to be added to the name of the new text file containing the translated text.
            //for the name of the new txt the word "translated" is translated into the selected language
            String traducireltituloalidiomaselect;
            try {
                //traducireltituloalidiomaselect = g.translateText(tituloDocumento,"en","fr");
                traducireltituloalidiomaselect = g.translateText(tituloDocumento,languageE,languageS);
                writeee(traducireltituloalidiomaselect + name[name.length-1],languageE,languageS); //nombre del archivo txt generado
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       //Create a new text file to which the translation of the text is added
        public static void writeee(String nombre,String languageE, String languageS) {
            File f;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter wr;
            try{//codigo para crear el nuevo archivo y escribir en el la traduccion
                f = new File(nombre);
                w = new FileWriter(f);
                bw = new BufferedWriter(w);
                wr = new PrintWriter(bw);
                wr.write(g.translateText(txt,languageE,languageS));

                wr.close();
                bw.close();

            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"ha sucedido un error" + e);
            }
        }
    }
