package com.jalasoft.convert.controller.response;

import com.jalasoft.convert.controller.response.VideoUploadResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoUploadResponseTest {
    @Test
    public void shouldReturnTheFileName(){
        String expected = "videoTest.mp4";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getFileName());
    }
    @Test
    public void shouldReturnTheFileType(){
        String expected = "mp4";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getFileType());
    }
    @Test
    public void shouldReturnTheNewName(){
        String expected = "videoResult.vmw";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getNewName());
    }
    @Test
    public void shouldReturnTheOutFormat(){
        String expected = ".vmw";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getOutformat());
    }
    @Test
    public void shouldReturnTheVolume(){
        String expected = "1";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getVolume());
    }
    @Test
    public void shouldReturnTheRemoveAudioValue(){
        String expected = "0";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getRemoveaudio());
    }
    @Test
    public void shouldReturnTheVideoBitrate(){
        String expected = "2000";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getVideoBitrate());
    }
    @Test
    public void shouldReturnTheAudioBitRate(){
        String expected = "250";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getAudioBitrate());
    }
    @Test
    public void shouldReturnTheFpsValue(){
        String expected = "30";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getFps());
    }
    @Test
    public void shouldReturnTheColorValue(){
        String expected = "1";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getColor());
    }
    @Test
    public void shouldReturnTheSizeValue(){
        String expected = "600x600";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        assertEquals(expected,videoUploadResponse.getSize());
    }

    /**
     * Set unit tests
     */

    @Test
    public void shouldSetTheFileName(){
        String expected = "videoSet.mp4";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setFileName("videoSet.mp4");
        assertEquals(expected,videoUploadResponse.getFileName());
    }
    @Test
    public void shouldSetTheFileType(){
        String expected = "vim";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setFileType("vim");
        assertEquals(expected,videoUploadResponse.getFileType());
    }
    @Test
    public void shouldSetTheNewName(){
        String expected = "videoSetResult.vmw";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setNewName("videoSetResult.vmw");
        assertEquals(expected,videoUploadResponse.getNewName());
    }
    @Test
    public void shouldSetTheOutFormat(){
        String expected = ".mp4";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setOutformat(".mp4");
        assertEquals(expected,videoUploadResponse.getOutformat());
    }
    @Test
    public void shouldSetTheVolume(){
        String expected = "3";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setVolume("3");
        assertEquals(expected,videoUploadResponse.getVolume());
    }
    @Test
    public void shouldSetTheRemoveAudioValue(){
        String expected = "5";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setRemoveaudio("5");
        assertEquals(expected,videoUploadResponse.getRemoveaudio());
    }
    @Test
    public void shouldSetTheVideoBitrate(){
        String expected = "4000";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setVideoBitrate("4000");
        assertEquals(expected,videoUploadResponse.getVideoBitrate());
    }
    @Test
    public void shouldSetTheAudioBitRate(){
        String expected = "500";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setAudioBitrate("500");
        assertEquals(expected,videoUploadResponse.getAudioBitrate());
    }
    @Test
    public void shouldSetTheFpsValue(){
        String expected = "60";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setFps("60");
        assertEquals(expected,videoUploadResponse.getFps());
    }
    @Test
    public void shouldSetTheColorValue(){
        String expected = "3";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setColor("3");
        assertEquals(expected,videoUploadResponse.getColor());
    }
    @Test
    public void shouldSetTheSizeValue(){
        String expected = "800x800";
        VideoUploadResponse videoUploadResponse = new VideoUploadResponse(
                "videoTest.mp4",
                "mp4",
                "videoResult.vmw",
                ".vmw",
                "1",
                "0",
                "2000",
                "250",
                "30",
                "1",
                "600x600"
        );
        videoUploadResponse.setSize("800x800");
        assertEquals(expected,videoUploadResponse.getSize());
    }
}
