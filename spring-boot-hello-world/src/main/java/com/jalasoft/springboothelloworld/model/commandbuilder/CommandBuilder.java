package com.jalasoft.springboothelloworld.model.commandbuilder;

import java.util.List;

public interface CommandBuilder {
    abstract public void setParameters(List<String> parameters);
    abstract public List<String> getCommand();
}
