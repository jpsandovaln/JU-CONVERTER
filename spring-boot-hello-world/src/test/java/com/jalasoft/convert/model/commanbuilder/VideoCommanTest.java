package com.jalasoft.convert.model.commanbuilder;

import com.jalasoft.convert.model.commandbuilder.VideoCommand;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
/**
 * It is responsible to test the VideoCommand Class, this class create a command with a list with the received parameters
 * @author Rodrigo Valda
 * @version 1.0
 */

public class VideoCommanTest {
    @Test
    public void shouldTestSetParametersMethod(){
        List<String> expectedCommand = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg", "-i", "Uploads\\video1.mp4", "-af", "volume=1.0", "-an",
                "-b:v", "2000k", "-b:a", "250k", "-ss", "as", "-to", "to", "-vf",
                "transpose=clock,fps=30,\"hue=s=1.0\",scale=600:600:force_original_aspect_ratio=decrease,pad=600:600:-1:-1:color=black", "-y", "Download\\hello.vmw",
        }));
        VideoCommand videoCommand = new VideoCommand();
        List<String> settings = new ArrayList<>();
        settings.add("Uploads\\video1.mp4");
        settings.add("hello");
        settings.add(".vmw");
        settings.add("1");
        settings.add("1");
        settings.add("2000");
        settings.add("250");
        settings.add("as to");
        settings.add("90");
        settings.add("30");
        settings.add("1");
        settings.add("600x600");
        settings.add("");
        videoCommand.setParameters(settings);
        videoCommand.getCommand();
        assertEquals(expectedCommand,videoCommand.getCommand());
    }

    /**
     * @Rodrigo Valda
     * Should return an IOException when all the parameters are equals to null
     */
    @Test (expected = IOException.class)
    public void shouldReturnCommandWithAVideoFile(){
        List<String> expectedCommand = new ArrayList<>(List.of(new String[]{
                "", "", "", "", "", "",
                "", "", "", "", "", "",
                "", "", "", "", "", "",
        }));
        VideoCommand videoCommand = new VideoCommand();
        List<String> settings = new ArrayList<>();
        settings.add("Uploads\\video1.mp4");
        settings.add("hello");
        settings.add(".vmw");
        settings.add("1");
        settings.add("1");
        settings.add("2000");
        settings.add("250");
        settings.add("as to");
        settings.add("90");
        settings.add("30");
        settings.add("1");
        settings.add("600x600");
        settings.add("");
        videoCommand.setParameters(settings);
        videoCommand.getCommand();
        assertEquals(expectedCommand,videoCommand.getCommand());
    }
}
