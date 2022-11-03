package com.jalasoft.convert.model.commanbuilder;

import com.jalasoft.convert.model.commandbuilder.ImageCommand;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * It is responsible to test the ImageCommand Class, this class create a command with a list with the received parameters
 * @author Rodrigo Valda
 * @version 1.0
 */
public class ImageCommandTest {

    @Test
    public void shouldTestSetParametersForImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithConvertProcess(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithToolResize(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "-resize",
                "50x100^",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("-resize");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithToolEmpty(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithToolLevel(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "-level",
                "50%,100%",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("-level");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithToolColorSpace(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "-colorspace",
                "gray",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("-colorspace");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForImageWithToolNull(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "convert",
                "Uploads\\test1.png",
                "Download\\test2.png.jpg"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("convert");
        settings.add("Uploads\\test1.png");
        settings.add("dont exist");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("jpg");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForPngImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.png"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("png");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }


    @Test
    public void shouldTestSetParametersForGifImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.gif"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("gif");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForTiffImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.tiff"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("tiff");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForWebpImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.webp"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("webp");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForPdfImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",
                "Download\\test2.png.pdf"
        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("pdf");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }

    @Test
    public void shouldTestSetParametersForDontFormartExistentImage(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe",
                "Uploads\\test1.png",
                "-rotate",
                "50",

        }));
        List<String> settings = new ArrayList<>();
        settings.add("Image");
        settings.add("Uploads\\test1.png");
        settings.add("-rotate");
        settings.add("50");
        settings.add("100");
        settings.add("green");
        settings.add("Download\\test2.png");
        settings.add("format dont exist");
        ImageCommand imageCommand = new ImageCommand(settings);
        assertEquals(expected,imageCommand.getCommand());
    }
}
