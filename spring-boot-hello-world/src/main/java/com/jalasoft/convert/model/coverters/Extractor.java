package com.jalasoft.convert.model.coverters;

import java.util.List;

import net.sourceforge.tess4j.TesseractException;

public abstract class Extractor {
    public abstract void extract(List<String> params) throws TesseractException;
}
