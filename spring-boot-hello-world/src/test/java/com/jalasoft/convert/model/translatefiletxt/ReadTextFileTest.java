package com.jalasoft.convert.model.translatefiletxt;
import org.junit.Test;

import com.jalasoft.convert.model.coverters.translatefiletxt.Gt_Translate;
import com.jalasoft.convert.model.coverters.translatefiletxt.ReadTextFile;
import com.jalasoft.convert.model.coverters.translatefiletxt.TxtFile;

import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReadTextFileTest {

    @Test
    public void shouldInitializeAllMapLanguages(){
        Gt_Translate gt_translate = new Gt_Translate();
        assertTrue(gt_translate.isSupport("es"));
    }
    @Test
    public void shouldReturnTextRead() throws IOException {
        String expectedResult = "Hello goodevenning, I am working on the unit tests";
        ReadTextFile readTextFile = new ReadTextFile();
        File file = new File("Downloads/testText.txt");
        assertEquals(expectedResult, readTextFile.readFile(file,StandardCharsets.UTF_8).trim());
    }

    @Test
    public void shouldReturnTextTranslated() throws Exception {
        String expectedSpanishResult = "Hola buenas noches, estoy trabajando en las pruebas unitarias.";
        String inputText = "Hello goodevenning, I am working on the unit tests";
        Gt_Translate gt_translate = new Gt_Translate();
        gt_translate.getInstance();
        String response = gt_translate.translateText(inputText,"en","es");
        assertEquals(expectedSpanishResult,response.trim());
    }

    @Test
    public void shouldReturnTheFileCode(){
        Gt_Translate gt_translate = new Gt_Translate();
        assertEquals("es",gt_translate.getCode("es"));
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnTheCode(){
        TxtFile.writeee("newTest.txt","en","es");
    }



    /**
     * The test case has to prove if the method getParameters bring back an FileNotFoundException
     * @throws TesseractException
     */
    @Test(expected = TesseractException.class)
    public void shouldGetPathWithErrorParameters(){
        TxtFile txtFile = new TxtFile();
        List<String> params = new ArrayList<>();
        params.add("");
        params.add("");
        params.add("");
        //txtFile.extract(params);
    }
}
