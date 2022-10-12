package ffmpeg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioConverter {
    List <String> command = new ArrayList<>();
    String volume;
    String fileName;
    String exe;
    String format;
    public AudioConverter(List<String> setup, String fileName) {
        exe = ("C:\\ffmpeg-master-latest-win64-gpl\\bin\\ffmpeg.exe");
        //fileName = "D:\\converter\\JU-CONVERTER\\ffmpeg\\7millas.mp3";
        this.fileName = fileName;
        command.add(exe);
        command.add("-i");
        command.add(fileName);
        setParameters(setup, getName(fileName));
    }
    public String getName(String name) {
        //String name = "7millas.mp3";
        String[] parts = name.split("\\.");
        format = parts[1];
        System.out.println(Arrays.asList(parts));
        return parts[0];
    }
    public void selectEncode(String encode) {

        switch (encode) {
            case "aac_encode":
                command.add("-c:a");
                command.add("aac");
                break;
            case "alac":
                command.add("-c:a");
                command.add("alac");
                System.out.println("alac");
                break;
            case "ac3":
                command.add("-c:a");
                command.add("ac3");
                break;
            case "aac_mf":
                command.add("-c:a");
                command.add("aac_mf");
        }
    }
    public void setVolume(int volume) {
        command.add("-vf");
        if (volume > 0) {
            command.add("volume=" + volume);
        }
    }
    public void selectAudioChannel(String channels) {

        switch (channels) {
            case "2":
                command.add("-ac");
                command.add("2");
                System.out.println("chanels 2");
                break;
            case "1":
                command.add("-ac");
                command.add("1");
                break;
        }
    }
    public void selectBitrateAudio(String bitrate) {

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
    public List<String> getCommand() {
        return command;
    }
    public void selectFormat(String format, String name) {
        switch (format) {
            case "mp3":
                command.add(name + "1.mp3");
                break;
            case "aac":
                command.add(name + "1.aac");
                break;
            case "m4a":
                command.add(name + "1.m4a");
                break;
            case "wma":
                command.add(name + "1.wma");
                break;
            case "wav":
                command.add(name + "1.wav");
                break;
        }
    }
    public void setParameters(List<String> setup, String name) {
        String value;
        if (setup.contains(format)) {

            for (int ind = 0; ind < setup.size(); ind++) {
                value  = setup.get(ind);
                //selectEncode(value);
                selectAudioChannel(value);
                selectBitrateAudio(value);
                selectFormat(value, name);
            }
        } else {
            for (int ind = 0; ind < setup.size(); ind++) {
                value  = setup.get(ind);
                selectEncode(value);
                selectAudioChannel(value);
                selectBitrateAudio(value);
                selectFormat(value, name);
            }
        }
        //System.out.println(command);
    }

}
