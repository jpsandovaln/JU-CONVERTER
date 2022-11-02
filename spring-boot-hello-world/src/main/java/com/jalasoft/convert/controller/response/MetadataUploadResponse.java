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
 * It is responsable for uploading Audios and converting them
 *
 * @author Rodrigo Bernal
 * @version 1.0
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class MetadataUploadResponse extends Response{

    private String outFormat;
    private String fileName;
    private String downloadMetadata;

    public MetadataUploadResponse (String fileName, String outFormat, String downloadMetadata) {
        super("200");
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
