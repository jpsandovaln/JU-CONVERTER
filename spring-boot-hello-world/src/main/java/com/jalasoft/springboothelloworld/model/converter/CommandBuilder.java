package com.jalasoft.springboothelloworld.model.converter;

import java.util.List;

public interface CommandBuilder {
    abstract public void setParameters(List<String> parameters);
    abstract public List<String> getCommand();
}
