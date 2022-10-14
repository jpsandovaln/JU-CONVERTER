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
    private String ffmpegPath = "ffmpeg\\bin\\ffmpeg";
    private String outName = "out";
    private String outFormat = ".mov";
    private List<String> command;
    boolean thereIsVf = false;
    String vfCommand = "";

    public VideoCommand() {}

    @Override
    public void setParameters(List<String> parameters) {
        List<String> settings = parameters.subList(0, 8);
        List<String> vfsetings = parameters.subList(8, 12);
        this.input = settings.get(0);
        initCommand();
        if (!settings.get(1).equals("")) {
            this.outName = parameters.get(1);
        }
        this.outFormat = settings.get(2);
        for (int index = 3; index < settings.size(); index++) {
            if (!settings.get(index).equals("")) {
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
                }
            }
        }
        VideoFilterCommand videoFilter = new VideoFilterCommand(vfsetings);
        if(!videoFilter.getCommandText().equals("")) {
            command.add("-vf");
            command.add(videoFilter.getCommandText());
        }
        command.add("-y");
        command.add("Download\\" + outName + outFormat);
    }
    @Override
    public List<String> getCommand() {
        System.out.println(command);
        return command;
    }

    private void initCommand() {
        command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(input);
    }
    private void setVolume(double vol) {
        command.add("-af");
        command.add("volume=" + vol);
    }
    private void removeAudio() {
        command.add("-an");
    }
    private void setVideoBitrate(int videoBitrate) {
        command.add("-b:v");
        command.add(videoBitrate + "k");
    }
    private void setAudioBitrate(int audioBitrate) {
        command.add("-b:a");
        command.add(audioBitrate + "k");
    }
    private void getFragment(String initTime, String finalTime) {
        command.add("-ss");
        command.add(initTime);
        command.add("-to");
        command.add(finalTime);
    }
}

