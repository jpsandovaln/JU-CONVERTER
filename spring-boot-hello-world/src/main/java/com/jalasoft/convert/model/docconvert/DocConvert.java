package com.jalasoft.convert.model.docconvert;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface DocConvert {
    void convert (InputStream inputStream, OutputStream outputStream) throws IOException;

    //
    //void laguage (InputStream doc, String typeLanguageOrigin, String typeLanguageTranslate);
}
