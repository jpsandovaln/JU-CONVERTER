package com.jalasoft.convert.model.translatefiletxt;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class ReadTextFileTest {
    String expectedResult = "Hello goodevenning, I am working on the unit tests";
    @Test
    public void shouldReturnTextRead() throws IOException {
        ReadTextFile readTextFile = new ReadTextFile();
        File file = new File("D:\\AutomationTesting\\Prog102\\gitRemote\\JU-CONVERTER\\spring-boot-hello-world\\Downloads\\testText.txt");
        assertEquals(expectedResult, readTextFile.readFile(file,StandardCharsets.UTF_8).trim());
    }

    @Test
    public void shouldReturnTextTranslated() throws Exception {
        String expectedSpanishResult = "Hola buenas noches, estoy trabajando en las pruebas unitarias.";
        Gt_Translate gt_translate = new Gt_Translate();
        gt_translate.getInstance();
        String response = gt_translate.translateText(expectedResult,"en","es");
        assertEquals(expectedSpanishResult,response.trim());
    }

    @Test
    public void shouldInitializeAllMapLanguages(){
        Gt_Translate gt_translate = new Gt_Translate();
        assertFalse(gt_translate.isSupport("es"));
        assertEquals(null,gt_translate.getCode("en"));
    }

    @Test
    public void shouldGetPath(){
        TxtFile txtFile = new TxtFile();
        txtFile.getPath("D:\\AutomationTesting\\Prog102\\gitRemote\\JU-CONVERTER\\spring-boot-hello-world\\Downloads\\testText.txt","en","es");
    }
}
