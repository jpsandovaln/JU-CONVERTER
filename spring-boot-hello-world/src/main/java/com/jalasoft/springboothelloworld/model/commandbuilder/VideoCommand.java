package com.jalasoft.springboothelloworld.model.commandbuilder;

import java.util.ArrayList;
import java.util.List;

public class VideoCommand implements CommandBuilder {
    private String input;
    private String ffmpegPath = "ffmpeg";
    private String outName = "out";
    private String outFormat = ".mov";
    private List<String> command;
    boolean thereIsVf = false;
    String vfCommand = "";

    public VideoCommand() {
    }

    @Override
    public void setParameters(List<String> parameters) {
        this.input = parameters.get(0);
        initCommand();
        if (!parameters.get(1).equals("")) {
            this.outName = parameters.get(1);
        }
        this.outFormat = parameters.get(2);
        for (int index = 3; index < parameters.size(); index++) {
            if (!parameters.get(index).equals("")) {
                switch (index){
                    case 3:
                        setVolume(Double.parseDouble(parameters.get(index)));
                        break;
                    case 4:
                        if (parameters.get(4) == "1") {
                            removeAudio();
                        }
                        break;
                    case 5:
                        setVideoBitrate(Integer.parseInt(parameters.get(index)));
                        break;
                    case 6:
                        setAudioBitrate(Integer.parseInt(parameters.get(index)));
                        break;
                    case 7:
                        String[] time = parameters.get(index).split(" ");
                        getFragment(time[0], time[1]);
                        break;
                    case 8:
                        vfRotateVideo(Integer.parseInt(parameters.get(index)));
                        break;
                    case 9:
                        vfSetFPS(Integer.parseInt(parameters.get(9)));
                        break;
                    case 10:
                        vfSetColor(Double.parseDouble(parameters.get(10)));
                        break;
                    case 11:
                        String[] size = parameters.get(11).split("x");
                        vfResize(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
                        break;
                    case 12:
                        String[] crop = parameters.get(12).split(":");
                        vfCropVideo(Integer.parseInt(crop[0]),Integer.parseInt(crop[1]),
                                    Integer.parseInt(crop[2]), Integer.parseInt(crop[3]));
                        break;
                }
            }
        }
        if (!vfCommand.equals("")) {
            command.add("-vf");
            command.add(vfCommand);
        }
    }
    @Override
    public List<String> getCommand() {
        command.add("-y");
        command.add("Uploads\\" + outName + outFormat);
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
    public void getFragment(String initTime, String finalTime) {
        command.add("-ss");
        command.add(initTime);
        command.add("-to");
        command.add(finalTime);
    }
    public void vfRotateVideo(int angle) {
        for (int rotate = 1; rotate <= angle/90; rotate ++) {
            if (thereIsVf) {
                vfCommand += ",";
            }
            vfCommand += "transpose=clock";
            thereIsVf = true;
        }
    }
    public void vfSetFPS(int fps) {
        if (thereIsVf) {
            vfCommand += ",";
        }
        vfCommand += "fps=" + fps;
        thereIsVf = true;
    }
    public void vfSetColor(double color) {
        if (thereIsVf) {
            vfCommand += ",";
        }
        vfCommand += "\"hue=s=" + color + "\""; // -vf "hue=s=0"
        thereIsVf = true;
    }

    public void vfResize(int width, int height) {
        if (thereIsVf) {
            vfCommand += ",";
        }
        vfCommand += "scale=" + width + ":" + height + ":force_original_aspect_ratio=decrease,pad="  + width + ":" + height + ":-1:-1:color=black";
        thereIsVf = true;
    }
    public void vfCropVideo(int width, int height, int posX, int posY) {
        if (thereIsVf) {
            vfCommand += ",";
        }
        vfCommand +="crop=" + width + ":" + height + ":" + posX + ":" + posY;
        thereIsVf = true;
    }
}

