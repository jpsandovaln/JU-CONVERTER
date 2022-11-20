package com.jalasoft.convert.model.coverters;

import java.util.ArrayList;
import java.util.List;

public class VideoConverterConfigurationValues implements ConverterConfigurationValues {
    private String fileName;
    private String newName;
    private String outFormat;
    private String volume;
    private String removeAudio;
    private String videoBitrate;
    private String audioBitrate;
    private String videoFragment;
    private String rotate;
    private String fps;
    private String color;
    private String size;
    private String cropVideo;
   //"Uploads\\" +
    public VideoConverterConfigurationValues(String fileName,
                                             String newName,
                                             String outFormat,
                                             String volume,
                                             String removeAudio,
                                             String videoBitrate,
                                             String audioBitrate,
                                             String videoFragment,
                                             String rotate,
                                             String fps,
                                             String color,
                                             String size,
                                             String cropVideo) {
        this.fileName = fileName;
        this.newName = newName;
        this.outFormat = outFormat;
        this.volume = volume;
        this.removeAudio = removeAudio;
        this.videoBitrate = videoBitrate;
        this.audioBitrate = audioBitrate;
        this.videoFragment = videoFragment;
        this.rotate = rotate;
        this.fps = fps;
        this.color = color;
        this.size = size;
        this.cropVideo = cropVideo;
    }

    public List<String> parameters() {
        List<String> parameters = new ArrayList<>();
        parameters.add(System.getProperty("user.dir") + "/Uploads/" + this.fileName);
        parameters.add(this.newName);
        parameters.add(this.outFormat);
        parameters.add(this.volume);
        parameters.add(this.removeAudio);
        parameters.add(this.videoBitrate);
        parameters.add(this.audioBitrate);
        parameters.add(this.videoFragment);
        parameters.add(this.rotate);
        parameters.add(this.fps);
        parameters.add(this.color);
        parameters.add(this.size);
        parameters.add(this.cropVideo);
        return parameters;
    }

    public String getNewName() {
        return newName;
    }

    public String getOutFormat() {
        return outFormat;
    }
}
