package com.jalasoft.convert.model.converters;

import com.jalasoft.convert.model.coverters.VideoConverterConfigurationValues;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * It is responsible to test the VideoConverterConfigurationValues Class, this class convert the file with a list
 * @author Rodrigo Valda
 * @version 1.0
 */
public class VideoConverterConfigurationValuesTest {
    @Test
    public void shouldTestIfAllParameterAreSendingCorrectly(){
        List<String> expectedList = new ArrayList<>(List.of(new String[]{
                "Uploads\\VideoTest1.mp4", "VideoResult.mp4", ".vmw","1", "0", "2000","250", "", "","30", "1", "600x600",""
        }));
        VideoConverterConfigurationValues video = new VideoConverterConfigurationValues(
                "VideoTest1.mp4",
                "VideoResult.mp4",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "",
                "",
                "30",
                "1",
                "600x600",
                ""
        );
        assertEquals(expectedList,video.parameters());
    }

    @Test
    public void shouldTestIfTheNewNameIsWorking(){
        List<String> listExample = new ArrayList<>(List.of(new String[]{
                "Uploads\\VideoTest1.mp4", "VideoResult.mp4", ".vmw","1", "0", "2000","250", "", "","30", "1", "600x600",""
        }));
        String expectedResult = "VideoResult.mp4";
        VideoConverterConfigurationValues video = new VideoConverterConfigurationValues(
                "VideoTest1.mp4",
                "VideoResult.mp4",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "",
                "",
                "30",
                "1",
                "600x600",
                ""
        );
        video.parameters();
        assertEquals(expectedResult,video.getNewName());
    }

    @Test
    public void shouldReturnVideoOutFormat(){
        List<String> listExample = new ArrayList<>(List.of(new String[]{
                "Uploads\\VideoTest1.mp4", "VideoResult.mp4", ".vmw","1", "0", "2000","250", "", "","30", "1", "600x600",""
        }));
        String expectedResult = ".vmw";
        VideoConverterConfigurationValues video = new VideoConverterConfigurationValues(
                "VideoTest1.mp4",
                "VideoResult.mp4",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "",
                "",
                "30",
                "1",
                "600x600",
                ""
        );
        video.parameters();
        assertEquals(expectedResult,video.getOutFormat());
    }

    /**
     * Should add exceptions or validations if send null parameters to VideoConverterConfigurationValues
     */

    @Test(expected = IOException.class)
    public void shouldReturnAnExceptionIfExistsNullParameters(){
        List<String> listExample = new ArrayList<>(List.of(new String[]{
                "Uploads\\VideoTest1.mp4", "VideoResult.mp4", ".vmw","1", "0", "2000","250", "", "","30", "1", "600x600",""
        }));
        String expectedResult = ".vmw";
        VideoConverterConfigurationValues video = new VideoConverterConfigurationValues(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        );
        video.parameters();
        assertEquals(expectedResult,video.getOutFormat());
    }
}
