package com.jalasoft.springboothelloworld.model.converter;

import java.util.ArrayList;
import java.util.List;

public class VideoConverter implements Converter {
    private String input;
    private String ffmpegPath = "ffmpeg";
    private String outName = "out";
    private String outFormat = ".mov";
    private List<String> command;

    public VideoConverter(String input) {
        this.input = input;
        initCommand();
    }
    /*public String getImages() {
        command += " %d.png";
        System.out.println (command);
        return command;
    }*/
    @Override
    public void setParameters(List<String> parameters) {

    }
    @Override
    public List<String> getCommand() {
        command.add("-y");
        command.add(outName + outFormat);
        //System.out.println (command);
        return command;
    }
    private void initCommand() {
        command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(input);
    }
    /*public void setVolume(double vol) {
        command += " -af volume=" + vol;
    }
    public void removeAudio() {
        command += " -an";
    }
    public void setVideoBitrate(int videoBitrate) {
        command += " -b:v " + videoBitrate + "k";
    }
    public void setAudioBitrate(int audioBitrate) {
        command += " -b:a " + audioBitrate + "k";
    }
    public void setOutName(String outName) {
        this.outName = outName;
    }*/
    public void setOutFormat(String outFormat) {
        this.outFormat = outFormat;
    }
    /*public void vfRotateVideo(int angle) {
        for (int rotate = 1; rotate <= angle/90; rotate ++) {
            command += !thereIsVf ? " -vf " : ",";
            command += "transpose=clock";
            thereIsVf = true;
        }
    }
    public void vfSetFPS(int fps) {
        command += !thereIsVf ? " -vf " : ",";
        command += "fps=" + fps;
        thereIsVf = true;
    }
    public void vfSetColor(int color) {
        command += !thereIsVf ? " -vf " : ",";
        command += "\"hue=s=" + color + "\""; // -vf "hue=s=0"
        thereIsVf = true;
    }

    public void vfResize(int width, int height) {
        command += !thereIsVf ? " -vf " : ",";
        command += "scale=" + width + ":-1";
        thereIsVf = true;
    }
    public void getFragment(String initTime, String finalTime) {
        command += " -ss " + initTime + " -to " + finalTime;
    }
    public void vfCropVideo(int width, int height, int posX, int posY) {
        command += !thereIsVf ? " -vf " : ",";
        command += "crop=" + width + ":" + height + ":" + posX + ":" + posY;
        thereIsVf = true;
    }*/
}