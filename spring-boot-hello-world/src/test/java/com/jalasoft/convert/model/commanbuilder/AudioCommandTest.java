package com.jalasoft.convert.model.commanbuilder;

import com.jalasoft.convert.model.commandbuilder.AudioCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AudioCommandTest {

    @Test(expected = NullPointerException.class)
    public void shouldTestTypeOfFileWithDifferentFormat(){
        String fileName = "testText.txt";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("testText.txt");
        parameters.add("128k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("txt");
        audioCommand.setParameters(parameters);
    }

    @Test(expected = NullPointerException.class)
    public void shouldTestTheBitRateAvailable(){
        String fileName = "audio.mo3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("audio.mp3");
        parameters.add("10k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("txt");
        audioCommand.setParameters(parameters);
    }

    @Test(expected = NullPointerException.class)
    public void shouldTestTheAudioChannelAvailable(){
        String fileName = "audio.mo3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("audio.mp3");
        parameters.add("128k");
        parameters.add("10");
        parameters.add("44100");
        parameters.add("txt");
        audioCommand.setParameters(parameters);
    }


    @Test
    public void shouldSetParameters(){
        String fileName = "audio.mp3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("audio.mp3");
        parameters.add("128k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("mp3");
        audioCommand.setParameters(parameters);
        //assertDoesNotThrow(() -> audioCommand.setParameters(parameters));
    }

    @Test
    public void shouldExecuteSamplingFrequencyMp3(){
        String fileName = "audio.mp3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters32000 = new ArrayList<>();
        parameters32000.add("audio.aac");
        parameters32000.add("160k");
        parameters32000.add("2");
        parameters32000.add("32000");
        parameters32000.add("aac");
        audioCommand.setParameters(parameters32000);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters32000));
    }
    @Test
    public void shouldExecuteSamplingFrequencyAac(){
        String fileName = "audio.aac";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters32000 = new ArrayList<>();
        parameters32000.add("audio.aac");
        parameters32000.add("160k");
        parameters32000.add("2");
        parameters32000.add("32000");
        parameters32000.add("aac");
        audioCommand.setParameters(parameters32000);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters32000));
    }
    @Test
    public void shouldExecuteSamplingFrequencyOgg(){
        String fileName = "audio.ogg";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters48000 = new ArrayList<>();
        parameters48000.add("audio.ogg");
        parameters48000.add("192k");
        parameters48000.add("2");
        parameters48000.add("48000");
        parameters48000.add("ogg");
        audioCommand.setParameters(parameters48000);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters48000));

    }
    @Test
    public void shouldExecuteSamplingFrequencyFlac(){
        String fileName = "audio.flac";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters96000 = new ArrayList<>();
        parameters96000.add("audio.flac");
        parameters96000.add("320k");
        parameters96000.add("1");
        parameters96000.add("96000");
        parameters96000.add("flac");
        audioCommand.setParameters(parameters96000);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters96000));
    }

    @Test
    public void shouldExecuteSamplingFrequencyFlacWma(){
        String fileName = "audio.flac";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters960002 = new ArrayList<>();
        parameters960002.add("audio.wma");
        parameters960002.add("320k");
        parameters960002.add("1");
        parameters960002.add("96000");
        parameters960002.add("wma");
        audioCommand.setParameters(parameters960002);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters960002));
    }

    @Test
    public void shouldExecuteSamplingFrequencyFlacWav(){
        String fileName = "audio.wav";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters960003 = new ArrayList<>();
        parameters960003.add("audio.wav");
        parameters960003.add("320k");
        parameters960003.add("1");
        parameters960003.add("96000");
        parameters960003.add("wav");
        audioCommand.setParameters(parameters960003);
        assertDoesNotThrow(() -> audioCommand.setParameters(parameters960003));
    }
}
