package com.jalasoft.convert.model.response;

import com.jalasoft.convert.controller.response.MetadataUploadResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetadataUploadResponseTest {
    @Test
    public void shouldReturnSetterFileName(){
        String expected = "NewMicrosoftImageTest.png";
        MetadataUploadResponse metadata = new MetadataUploadResponse(
                "MicrosoftTeams.png",
                "txt",
                "Download:txt"
        );
        metadata.setFileName("NewMicrosoftImageTest.png");
        assertEquals(expected,metadata.getFileName());
    }

    @Test
    public void shouldReturnSetterOutFormat(){
        String expected = "doc";
        MetadataUploadResponse metadata = new MetadataUploadResponse(
                "MicrosoftTeams.png",
                "txt",
                "Download:txt"
        );
        metadata.setOutFormat("doc");
        assertEquals(expected,metadata.getOutFormat());
    }

    @Test
    public void shouldReturnSetterDownloadMetadata(){
        String expected = "Download:data/txt";
        MetadataUploadResponse metadata = new MetadataUploadResponse(
                "MicrosoftTeams.png",
                "txt",
                "Download:txt"
        );
        metadata.setDownloadMetadata("Download:data/txt");
        assertEquals(expected,metadata.getDownloadMetadata());
    }
}
