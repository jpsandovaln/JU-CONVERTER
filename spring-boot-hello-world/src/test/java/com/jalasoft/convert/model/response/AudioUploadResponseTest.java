package com.jalasoft.convert.model.response;

import com.jalasoft.convert.controller.response.AudioUploadResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AudioUploadResponseTest {
    @Test
    public void shouldTestFileNameParameterAreNotNull(){
        String expected = "audio.mp3";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getFileName());
    }

    @Test
    public void shouldTestFileTypeParameterAreNotNull(){
        String expected = "mp3";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getFileType());
    }

    @Test
    public void shouldTestSizeParameterAreNotNull(){
        long expected = 149;
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getSize());
    }

    @Test
    public void shouldTestBitRateParameterAreNotNull(){
        String expected = "128k";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getBitrate());
    }

    @Test
    public void shouldTestChannelsParameterAreNotNull(){
        String expected = "2";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getChannels());
    }

    @Test
    public void shouldTestSamplyFrequencyParameterAreNotNull(){
        String expected = "44100";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getSamplingFrequency());
    }

    @Test
    public void shouldTestFormatParameterAreNotNull(){
        String expected = "mp3";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        assertEquals(expected,audioUploadResponse.getFormat());
    }

    @Test
    public void testSetNewFileNameParameter(){
        String expected = "newAudio1.mp3";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setFileName("newAudio1.mp3");
        assertEquals(expected,audioUploadResponse.getFileName());
    }

    @Test
    public void testSetFileTypeNameParameter(){
        String expected = "wav";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setFileType("wav");
        assertEquals(expected,audioUploadResponse.getFileType());
    }

    @Test
    public void testSetSizeNameParameter(){
        long expected = 180;
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setSize(180);
        assertEquals(expected,audioUploadResponse.getSize());
    }

    @Test
    public void testSetBitRateNameParameter(){
        String expected = "256k";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setBitrate("256k");
        assertEquals(expected,audioUploadResponse.getBitrate());
    }

    @Test
    public void testSetNewChannelsParameter(){
        String expected = "1";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setChannels("1");
        assertEquals(expected,audioUploadResponse.getChannels());
    }

    @Test
    public void testSetNewSampleFrequencyParameter(){
        String expected = "96000";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setSamplingFrequency("96000");
        assertEquals(expected,audioUploadResponse.getSamplingFrequency());
    }

    @Test
    public void testSetNewFormatParameter(){
        String expected = "tiff";
        AudioUploadResponse audioUploadResponse = new AudioUploadResponse(
                "audio.mp3",
                "mp3",
                149,
                "128k",
                "2",
                "44100",
                "mp3"
        );
        audioUploadResponse.setFormat("tiff");
        assertEquals(expected,audioUploadResponse.getFormat());
    }

}
