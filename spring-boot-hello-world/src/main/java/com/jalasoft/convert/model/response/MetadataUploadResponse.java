/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.response;

/**
 * It is responsable for uploading Audios and converting them
 *
 * @author Rodrigo Bernal
 * @version 1.0
 */
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
