/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.commandbuilder;

import java.util.List;

public interface CommandBuilder {
    abstract public void setParameters(List<String> parameters);

    abstract public List<String> getCommand();
}
