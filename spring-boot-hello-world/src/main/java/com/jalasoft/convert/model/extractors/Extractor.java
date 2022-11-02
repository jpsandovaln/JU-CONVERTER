package com.jalasoft.convert.model.extractors;

import com.jalasoft.convert.common.exception.ExtractorException;
import com.jalasoft.convert.common.exception.ReadFileException;

import java.util.List;

public abstract class Extractor {
    public abstract void extract(List<String> params) throws ExtractorException, ReadFileException;
}
