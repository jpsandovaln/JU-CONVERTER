package com.jalasoft.springboothelloworld.model.converter;

import java.util.ArrayList;
import java.util.List;

public class VideoConverter implements Converter {
    private String input;
    private String ffmpegPath = "ffmpeg";
    private String outName = "out";
    private String outFormat = ".mov";
    private List<String> command;
    boolean thereIsVf = false;
    String vfCommand = "";

    public VideoConverter() {
        initCommand();
    }
    /*public String getImages() {
        command += " %d.png";
        System.out.println (command);
        return command;
    }*/

    @Override
    public void setParameters(List<String> parameters) {
        this.input = parameters.get(0);
        initCommand();
        this.outName = parameters.get(2);
        this.outFormat = parameters.get(3);
        setVolume(Double.parseDouble(parameters.get(4)));
        if (parameters.get(5) == "1") {
            removeAudio();
        }
        if (parameters.get(6) != "") {
            setVideoBitrate(Integer.parseInt(parameters.get(6)));
        }
        if (parameters.get(7) != "") {
            setAudioBitrate(Integer.parseInt(parameters.get(7)));
        }
        if (parameters.get(8) != "") {
            vfSetFPS(Integer.parseInt(parameters.get(8)));
        }if (parameters.get(8) != "") {
            vfSetFPS(Integer.parseInt(parameters.get(8)));
        }
        vfSetColor(Double.parseDouble(parameters.get(9)));
        if (parameters.get(10) != "") {
            String[] size = parameters.get(10).split("x");
            vfResize(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
        }
        command.add(vfCommand);
    }
    @Override
    public List<String> getCommand() {
        command.add("-y");
        command.add(outName + outFormat);
        System.out.println(command);
        return command;
    }
    private void initCommand() {
        command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(input);
    }
    public void setVolume(double vol) {
        command.add("-af");
        command.add("volume=" + vol);
    }
    public void removeAudio() {
        command.add("-an");
    }
    public void setVideoBitrate(int videoBitrate) {
        command.add("-b:v");
        command.add(videoBitrate + "k");
    }
    public void setAudioBitrate(int audioBitrate) {
        command.add("-b:a");
        command.add(audioBitrate + "k");
    }
    public void setOutName(String outName) {
        this.outName = outName;
    }
    public void setOutFormat(String outFormat) {
        this.outFormat = outFormat;
    }
    public void vfRotateVideo(int angle) {
        for (int rotate = 1; rotate <= angle/90; rotate ++) {
            if (!thereIsVf) {
                command.add("-vf");
            } else {
                vfCommand += ",";
            }
            vfCommand += "transpose=clock";
            thereIsVf = true;
        }
    }
    public void vfSetFPS(int fps) {
        if (!thereIsVf) {
            command.add("-vf");
        } else {
            vfCommand += ",";
        }
        vfCommand += "fps=" + fps;
        thereIsVf = true;
    }
    public void vfSetColor(double color) {
        if (!thereIsVf) {
            command.add("-vf");
        } else {
            vfCommand += ",";
        }
        vfCommand += "\"hue=s=" + color + "\""; // -vf "hue=s=0"
        thereIsVf = true;
    }

    public void vfResize(int width, int height) {
        if (!thereIsVf) {
            command.add("-vf");
        } else {
            vfCommand += ",";
        }
        //vfCommand += "scale=" + width + ":-1,scale=-1:" + height;
        vfCommand += "scale=" + width + ":" + height + ":force_original_aspect_ratio=decrease,pad="  + width + ":" + height + ":-1:-1:color=black";
        //scale=1280:720:force_original_aspect_ratio=decrease,pad=1280:720:-1:-1:color=black
        thereIsVf = true;
    }
    public void getFragment(String initTime, String finalTime) {
        command.add("-ss");
        command.add(initTime);
        command.add("-to");
        command.add(finalTime);
    }
    public void vfCropVideo(int width, int height, int posX, int posY) {
        if (!thereIsVf) {
            command.add("-vf");
        } else {
            vfCommand += ",";
        }
        vfCommand +="crop=" + width + ":" + height + ":" + posX + ":" + posY;
        thereIsVf = true;
    }
}