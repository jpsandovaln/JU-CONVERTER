package com.jalasoft.convert.model.commanbuilder;

import com.jalasoft.convert.model.commandbuilder.AudioCommand;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * It is responsible to test the AudioCommand Class, this class create a command with a list with the received parameters
 * @author Rodrigo Valda
 * @version 1.0
 */
public class AudioCommandTest {

    /**
     * The unit test has to prove if the audioCommand generate a command for txt file
     */
    @Test(expected = IOException.class)
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

    /**
     * The unit test has to prove when AudioCommand does not have parameters
     */
    @Test(expected = IOException.class)
    public void shouldTestCreateCommandWithNullParameter(){
        String fileName = "";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("testText.txt");
        parameters.add("128k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("txt");
        audioCommand.setParameters(parameters);
    }


    /**
     * The unit test has to prove if the user send a null file to the class
     */
    @Test(expected = NullPointerException.class)
    public void shouldTestWithNullFileToTheClass(){
        String fileName = null;
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("audio.mp3");
        parameters.add("10k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("txt");
        audioCommand.setParameters(parameters);
    }

    /**
     * The unit test has to the if the list is empty to generate the command
     */
    @Test(expected = IOException.class)
    public void shouldTestIfTheListToBuildCommandIsEmpty(){
        String fileName = "audio.mo3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("");
        parameters.add("");
        parameters.add("");
        parameters.add("");
        parameters.add("");
        audioCommand.setParameters(parameters);
    }


    @Test
    public void shouldSetParameters(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.mp3",
                "-b:a",
                "128k",
                "-ac",
                "2",
                "-ar",
                "44100",
                "Download\\audio1.mp3",
        }));
        String fileName = "audio.mp3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters = new ArrayList<>();
        parameters.add("audio.mp3");
        parameters.add("128k");
        parameters.add("2");
        parameters.add("44100");
        parameters.add("mp3");
        audioCommand.setParameters(parameters);
        assertEquals(expected,audioCommand.getCommand());
        //assertDoesNotThrow(() -> audioCommand.setParameters(parameters));
    }

    @Test
    public void shouldExecuteSamplingFrequencyMp3(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.mp3",
                "-b:a",
                "160k",
                "-ac",
                "2",
                "-ar",
                "32000",
                "Download\\audio1.aac",
        }));
        String fileName = "audio.mp3";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters32000 = new ArrayList<>();
        parameters32000.add("audio.aac");
        parameters32000.add("160k");
        parameters32000.add("2");
        parameters32000.add("32000");
        parameters32000.add("aac");
        audioCommand.setParameters(parameters32000);
        assertEquals(expected,audioCommand.getCommand());
    }
    @Test
    public void shouldExecuteSamplingFrequencyAac(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.aac",
                "-b:a",
                "160k",
                "-ac",
                "2",
                "-ar",
                "32000",
                "Download\\audio1.aac",
        }));
        String fileName = "audio.aac";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters32000 = new ArrayList<>();
        parameters32000.add("audio.aac");
        parameters32000.add("160k");
        parameters32000.add("2");
        parameters32000.add("32000");
        parameters32000.add("aac");
        audioCommand.setParameters(parameters32000);
        assertEquals(expected,audioCommand.getCommand());
    }
    @Test
    public void shouldExecuteSamplingFrequencyOgg(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.ogg",
                "-b:a",
                "192k",
                "-ac",
                "2",
                "-ar",
                "48000",
                "Download\\audio1.ogg",
        }));
        String fileName = "audio.ogg";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters48000 = new ArrayList<>();
        parameters48000.add("audio.ogg");
        parameters48000.add("192k");
        parameters48000.add("2");
        parameters48000.add("48000");
        parameters48000.add("ogg");
        audioCommand.setParameters(parameters48000);
        assertEquals(expected,audioCommand.getCommand());

    }
    @Test
    public void shouldExecuteSamplingFrequencyFlac(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.flac",
                "-b:a",
                "320k",
                "-ac",
                "1",
                "-ar",
                "96000",
                "Download\\audio1.flac",
        }));
        String fileName = "audio.flac";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters96000 = new ArrayList<>();
        parameters96000.add("audio.flac");
        parameters96000.add("320k");
        parameters96000.add("1");
        parameters96000.add("96000");
        parameters96000.add("flac");
        audioCommand.setParameters(parameters96000);
        assertEquals(expected,audioCommand.getCommand());
    }

    @Test
    public void shouldExecuteSamplingFrequencyFlacWma(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.wma",
                "-b:a",
                "320k",
                "-ac",
                "1",
                "-ar",
                "96000",
                "Download\\audio1.wma",
        }));
        String fileName = "audio.wma";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters960002 = new ArrayList<>();
        parameters960002.add("audio.wma");
        parameters960002.add("320k");
        parameters960002.add("1");
        parameters960002.add("96000");
        parameters960002.add("wma");
        audioCommand.setParameters(parameters960002);
        assertEquals(expected,audioCommand.getCommand());
    }

    @Test
    public void shouldExecuteSamplingFrequencyFlacWav(){
        List<String> expected = new ArrayList<>(List.of(new String[]{
                "ffmpeg\\bin\\ffmpeg.exe",
                "-i",
                "audio.wav",
                "-b:a",
                "320k",
                "-ac",
                "1",
                "-ar",
                "96000",
                "Download\\audio1.wav",
        }));
        String fileName = "audio.wav";
        AudioCommand audioCommand = new AudioCommand(fileName);
        List<String> parameters960003 = new ArrayList<>();
        parameters960003.add("audio.wav");
        parameters960003.add("320k");
        parameters960003.add("1");
        parameters960003.add("96000");
        parameters960003.add("wav");
        audioCommand.setParameters(parameters960003);
        assertEquals(expected,audioCommand.getCommand());
    }
}
