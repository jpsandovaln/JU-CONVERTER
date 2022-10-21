package com.jalasoft.convert.response;

public class MetadataUploadResponse {

    private String outFormat;
    private String fileName;
    private String downloadMetadata;

    public MetadataUploadResponse (String fileName, String outFormat, String downloadMetadata) {
        this.fileName = fileName;
        this.outFormat = outFormat;
        this.downloadMetadata = downloadMetadata;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOutFormat() {
        return outFormat;
    }

    public void setOutFormat(String outFormat) {
        this.outFormat = outFormat;
    }

    public String getDownloadMetadata() {
        return downloadMetadata;
    }

    public void setDownloadMetadata(String downloadMetadata) {
        this.downloadMetadata = downloadMetadata;
    }
}
