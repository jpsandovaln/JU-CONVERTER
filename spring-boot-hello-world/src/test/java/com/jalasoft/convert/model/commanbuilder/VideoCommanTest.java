package com.jalasoft.convert.model.commanbuilder;

import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import com.jalasoft.convert.model.coverters.VideoConverterConfigurationValues;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VideoCommanTest {
    @Test
    public void shouldTestSetParametersMethod(){
        VideoCommand videoCommand = new VideoCommand();
        List<String> settings = new ArrayList<>();

        videoCommand.setParameters(settings);
    }

    @Test
    public void shouldReturnCommandWithAfVolume(){
        VideoCommand videoCommand = new VideoCommand();
        List<String> settings = new ArrayList<>();
        settings.add("Uploads\\video1.mp4");
        settings.add("video2.mp4");
        settings.add("2");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        settings.add("Uploads\\video1.mp4");
        videoCommand.setParameters(settings);
        videoCommand.getCommand();
    }
}
