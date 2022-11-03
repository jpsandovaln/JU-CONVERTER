package com.jalasoft.convert.controller.response;

import com.jalasoft.convert.controller.response.UploadFileResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UploadFileResponseTest {
    @Test
    public void shouldTestSetterFileNameParameter(){
        String expected = "newTestText.txt";
        UploadFileResponse upload = new UploadFileResponse(
                "testText.txt",
                "textDownloaded",
                "txt",
                4000
        );
        upload.setFileName("newTestText.txt");
        assertEquals(expected,upload.getFileName());
    }

    @Test
    public void shouldTestSetterFileDownloadUriParameter(){
        String expected = "newTextDownloadTest";
        UploadFileResponse upload = new UploadFileResponse(
                "testText.txt",
                "textDownload",
                "txt",
                4000
        );
        upload.setFileDownloadUri("newTextDownloadTest");
        assertEquals(expected,upload.getFileDownloadUri());
    }

    @Test
    public void shouldTestSetterFileTypeeParameter(){
        String expected = "doc";
        UploadFileResponse upload = new UploadFileResponse(
                "testText.txt",
                "textDownloaded",
                "txt",
                4000
        );
        upload.setFileType("doc");
        assertEquals(expected,upload.getFileType());
    }

    @Test
    public void shouldTestSetterSizeParameter(){
        long expected = 8000;
        UploadFileResponse upload = new UploadFileResponse(
                "testText.txt",
                "textDownloaded",
                "txt",
                4000
        );
        upload.setSize(8000);
        assertEquals(expected,upload.getSize());
    }
}
