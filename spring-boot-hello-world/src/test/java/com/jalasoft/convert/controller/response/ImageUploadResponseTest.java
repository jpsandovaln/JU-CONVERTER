package com.jalasoft.convert.controller.response;

import com.jalasoft.convert.controller.response.ImageUploadResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImageUploadResponseTest {
    @Test
    public void shouldReturnProcessValue(){
        String expected = "convert";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getProcess());
    }

    @Test
    public void shouldReturnFilesParameterValue(){
        String expected = "testImage.png";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getFile());
    }

    @Test
    public void shouldReturnToolValue(){
        String expected = "-colorspace";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getTool());
    }

    @Test
    public void shouldReturnWidthBlackValue(){
        String expected = "10";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getWidth_black());
    }

    @Test
    public void shouldReturnHeightWhiteValue(){
        String expected = "10";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getHeight_white());
    }

    @Test
    public void shouldReturnColorValue(){
        String expected = "0";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getColor());
    }

    @Test
    public void shouldReturnFileOutValue(){
        String expected = "testResponse";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getFileout());
    }

    @Test
    public void shouldReturnFormatValue(){
        String expected = "png";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        assertEquals(expected,imageResponse.getFormat());
    }

    /**
     * The next unit test should if the parameters are changing with the setters
     */

    @Test
    public void shouldReturnTheSetterProcessValue(){
        String expected = "rotate";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setProcess("rotate");
        assertEquals(expected,imageResponse.getProcess());
    }

    @Test
    public void shouldReturnTheSetterFilesParameterValue(){
        String expected = "newTestImage.png";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setFile("newTestImage.png");
        assertEquals(expected,imageResponse.getFile());
    }

    @Test
    public void shouldReturnTheSetterToolValue(){
        String expected = "-rotate";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setTool("-rotate");
        assertEquals(expected,imageResponse.getTool());
    }

    @Test
    public void shouldReturnTheSetterWidthBlackValue(){
        String expected = "20";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setWidth_black("20");
        assertEquals(expected,imageResponse.getWidth_black());
    }

    @Test
    public void shouldReturnTheSetterHeightWhiteValue(){
        String expected = "30";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setHeight_white("30");
        assertEquals(expected,imageResponse.getHeight_white());
    }

    @Test
    public void shouldReturnTheSetterColorValue(){
        String expected = "5";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setColor("5");
        assertEquals(expected,imageResponse.getColor());
    }

    @Test
    public void shouldReturnTheSetterFileOutValue(){
        String expected = "newTestResponse";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setFileout("newTestResponse");
        assertEquals(expected,imageResponse.getFileout());
    }

    @Test
    public void shouldReturnTheSetterFormatValue(){
        String expected = "jpg";
        ImageUploadResponse imageResponse = new ImageUploadResponse(
                "convert",
                "testImage.png",
                "-colorspace",
                "10",
                "10",
                "0",
                "testResponse",
                "png"
        );
        imageResponse.setFormat("jpg");
        assertEquals(expected,imageResponse.getFormat());
    }

}
