package com.jalasoft.springboothelloworld.response;

public class VideoUploadResponse {
    private String fileName;
    private String fileType;
    private String newName;
    private String outformat;
    private String volume;
    private String removeaudio;
    private String videoBitrate;
    private String audioBitrate;
    private String fps;
    private String color;
    private String size;

    public VideoUploadResponse(String fileName, String fileType, String newName, String outformat,String volume, String removeaudio,String videoBitrate,String audioBitrate,  String fps, String color,String size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.newName = newName;
        this.size = size;
        this.videoBitrate = videoBitrate;
        this.audioBitrate = audioBitrate;
        this.volume = volume;
        this.removeaudio = removeaudio;
        this.outformat = outformat;
        this.fps = fps;
        this.color = color;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getOutformat() {
        return outformat;
    }

    public void setOutformat(String outformat) {
        this.outformat = outformat;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getRemoveaudio() {
        return removeaudio;
    }

    public void setRemoveaudio(String removeaudio) {
        this.removeaudio = removeaudio;
    }

    public String getVideoBitrate() {
        return videoBitrate;
    }

    public void setVideoBitrate(String videoBitrate) {
        this.videoBitrate = videoBitrate;
    }

    public String getAudioBitrate() {
        return audioBitrate;
    }

    public void setAudioBitrate(String audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    public String getFps() {
        return fps;
    }

    public void setFps(String fps) {
        this.fps = fps;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
    
}