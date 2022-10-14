/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.springboothelloworld.model.commandbuilder;
/**
 * It is responsible for assembling a command with user requirements for video file conversion.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class VideoCommand implements CommandBuilder {
    private String input;
    private String ffmpegPath = "ffmpeg\\bin\\ffmpeg.exe";
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
        setVolume(Double.parseDouble(parameters.get(3)));
        if (parameters.get(4) == "1") {
            removeAudio();
        }
        if (!parameters.get(5).equals("")) {
            setVideoBitrate(Integer.parseInt(parameters.get(5)));
        }
        if (!parameters.get(6).equals("")) {
            setAudioBitrate(Integer.parseInt(parameters.get(6)));
        }
        if (!parameters.get(7).equals("")) {
            String[] time = parameters.get(7).split(" ");
            getFragment(time[0], time[1]);
        }
        if (!parameters.get(8).equals("")) {
            vfRotateVideo(Integer.parseInt(parameters.get(8)));
        }
        if (!parameters.get(9).equals("")) {
            vfSetFPS(Integer.parseInt(parameters.get(9)));
        }
        vfSetColor(Double.parseDouble(parameters.get(10)));
        if (!parameters.get(12).equals("")) {
            String[] size = parameters.get(12).split(":");
            vfCropVideo(Integer.parseInt(size[0]),Integer.parseInt(size[1]), Integer.parseInt(size[2]), Integer.parseInt(size[3]));
        }
        if (!parameters.get(11).equals("")) {
            String[] size = parameters.get(11).split("x");
            vfResize(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
        }
        if (!vfCommand.equals("")) {
            command.add(vfCommand);
        }
    }
    @Override
    public List<String> getCommand() {
        command.add("-y");
        command.add("Download\\" + outName + outFormat);
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
        vfCommand += "scale=" + width + ":" + height + ":force_original_aspect_ratio=decrease,pad="  + width + ":" + height + ":-1:-1:color=black";
        thereIsVf = true;
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

