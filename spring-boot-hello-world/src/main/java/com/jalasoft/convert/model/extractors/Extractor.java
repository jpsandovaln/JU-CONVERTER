package com.jalasoft.convert.model.extractors;

import java.util.List;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.common.exception.ReadFileException;

public abstract class Extractor {
    public abstract void extract(List<String> params) throws ExtractorException, ReadFileException;
}
