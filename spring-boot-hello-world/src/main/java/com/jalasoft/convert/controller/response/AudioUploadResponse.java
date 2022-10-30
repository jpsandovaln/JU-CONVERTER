/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.controller.response;
/**
 * It is responsable returning a response to a request 
 *
 * @author Fernanda Aguilar
 * @version 1.0
 */
public class AudioUploadResponse extends Response{
    private String fileName;
    private String fileType;
    private long size;
    private String bitrate;
    private String channels;
    private String samplingFrequency;
    private String format;


    public AudioUploadResponse(String fileName, String fileType, long size, String bitrate, String channels, String samplingFrequency, String format) {
        super("200");
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
        this.bitrate = bitrate;
        this.channels = channels;
        this.samplingFrequency = samplingFrequency;
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


    public String getSamplingFrequency() {
        return samplingFrequency;
    }


    public void setSamplingFrequency(String samplingFrequency) {
        this.samplingFrequency = samplingFrequency;
    }


    public String getFormat() {
        return format;
    }


    public void setFormat(String format) {
        this.format = format;
    }

}
