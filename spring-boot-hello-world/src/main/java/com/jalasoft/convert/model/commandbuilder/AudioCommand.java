/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.commandbuilder;
import java.util.ArrayList;
import java.util.List;
/**
 * It is responsible for assembling a command with user requirements for audio file conversion.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class AudioCommand implements CommandBuilder {

    List <String> command = new ArrayList<>();
    String fileName;
    String exe;
    String format;

    public AudioCommand(String fileName) {
        exe = ("ffmpeg\\bin\\ffmpeg.exe");
        this.fileName = fileName;
        command.add(exe);
        command.add("-i");
        command.add(fileName);
    }
    private String getName(String name) {
        String[] parts = name.split("\\.");
        format = parts[1];
        return parts[0];
    }
    private void selectSamplingFrequency(String sampligFrecuency) {

        switch (sampligFrecuency) {
            case "32000":
                command.add("-ar");
                command.add("32000");
                break;
            case "44100":
                command.add("-ar");
                command.add("44100");
                break;
            case "48000":
                command.add("-ar");
                command.add("48000");
                break;
            case "96000":
                command.add("-ar");
                command.add("96000");
        }
    }

    private void selectAudioChannel(String channels) {
            switch (channels) {
                case "2":
                    command.add("-ac");
                    command.add("2");
                    break;
                case "1":
                    command.add("-ac");
                    command.add("1");
                    break;
                default:

            }
    }
    private void selectBitrateAudio(String bitrate) {

        switch (bitrate) {
            case "128k":
                command.add("-b:a");
                command.add("128k");
                break;
            case "160k":
                command.add("-b:a");
                command.add("160k");
                break;
            case "192k":
                command.add("-b:a");
                command.add("192k");
                break;
            case "320k":
                command.add("-b:a");
                command.add("320k");
                break;
        }
    }
    private void selectFormat(String format, String name) {
        switch (format) {
            case "mp3":
                command.add(name + ".mp3");
                break;
            case "aac":
                command.add(name + ".aac");
                break;
            case "ogg":
                command.add(name + ".ogg");
                break;
            case "flac":
                command.add(name + ".flac");
                break;
            case "wma":
                command.add(name + ".wma");
                break;
            case "wav":
                command.add(name + ".wav");
                break;
        }
    }

    @Override
    public void setParameters(List<String> parameters) {
        String value;
        for (int ind = 0; ind < parameters.size(); ind++) {
            value  = parameters.get(ind);
            selectSamplingFrequency(value);
            selectAudioChannel(value);
            selectBitrateAudio(value);
            selectFormat(value, getName("Download\\" + parameters.get(0)));
        }
    }
    @Override
    public List<String> getCommand() {
        return command;
    }

}
