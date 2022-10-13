package com.jalasoft.springboothelloworld.response;

public class AudioUploadResponse {
    private String fileName;
    private String fileType;
    private long size;
    private String bitrate;
    private String channels;
    private String encode;
    private String format;


    public AudioUploadResponse(String fileName, String fileType, long size, String bitrate, String channels, String encode, String format) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
        this.bitrate = bitrate;
        this.channels = channels;
        this.encode = encode;
        this.format = format;

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


    public long getSize() {
        return size;
    }


    public void setSize(long size) {
        this.size = size;
    }


    public String getBitrate() {
        return bitrate;
    }


    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }


    public String getChannels() {
        return channels;
    }


    public void setChannels(String channels) {
        this.channels = channels;
    }


    public String getEncode() {
        return encode;
    }


    public void setEncode(String encode) {
        this.encode = encode;
    }


    public String getFormat() {
        return format;
    }


    public void setFormat(String format) {
        this.format = format;
    }

}
