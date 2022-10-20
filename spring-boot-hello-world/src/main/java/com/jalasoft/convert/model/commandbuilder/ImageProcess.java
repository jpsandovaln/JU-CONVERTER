/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.convert.model.commandbuilder;

/**
 * It is responsible for assembling a command with user requirements for audio file conversion.
 *
 * @author Daniela Martinez
 * @version 1.0
 */

public class ImageProcess {
    public ImageProcess () {//, String inputPath, String tool, String characteristic, String outputPath) {
        super();

    }

    protected static String resize (String width, String height) {
        if (width == "" && height == "") {
            return "";
        } else {
            String x_width = String.valueOf(width);
            String y_height = String.valueOf(height);
            String finalResize =  x_width + "x" + y_height + "^";
            return finalResize.toString();
        }

    }

    protected static String colorSpace (String colorSpace) {
     return "gray";
    }

    protected static String level(String blackPoint, String whitePoint) {
        String blackLevel = String.valueOf(blackPoint);
        String whiteLevel = String.valueOf(whitePoint);
        String finalLevel = blackLevel + "%" + "," + whiteLevel + "%";
        return finalLevel.toString();
    }

    protected static String rotate(String grades) {
        return grades;
    }

}
