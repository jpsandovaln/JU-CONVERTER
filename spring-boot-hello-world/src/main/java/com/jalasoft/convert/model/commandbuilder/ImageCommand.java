/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package com.jalasoft.convert.model.commandbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * It is responsible for assembling a command with user requirements for audio file conversion.
 *
 * @author Daniela Martinez
 * @version 1.0
 */

public class ImageCommand implements CommandBuilder {
    private static ImageProcess imageprocess;
    List<String> command = new ArrayList<>();
    List<String> setup = new ArrayList<>();
    String tool;
    String format;
    String width_black;
    String height_white;
    String colorspace;

    public ImageCommand(List<String> setup) {
        // C:\\Program Files\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe
        command.add("magick\\ImageMagick-7.1.0-Q16-HDRI\\magick.exe");
        setParameters(setup);

        imageprocess = new ImageProcess();
    }

    private void filepath(String fileName) {
        command.add(fileName);
    }

    private void processImage(String process) {
        switch (process) {
            case "convert":
                command.add("convert");

                System.out.println("choose convert image");
            case "montage":
                System.out.println("choose do a montage image");

            default:
                System.out.println("It's not the process you are looking for");
        }
    }

    private void tool(String tool, String width_black, String height_white, String color_rotate) {
        switch (tool) {

            case "-resize":
                command.add("-resize");
                command.add(imageprocess.resize(width_black, height_white));
                System.out.println("choose to change the size of the image");
                break;

            case "-colorspace":
                command.add("-colorspace");
                command.add(imageprocess.colorSpace(colorspace));
                System.out.println("choose the tool to change the color of the image");
                break;

            case "-level":
                command.add("-level");
                command.add(imageprocess.level(width_black, height_white));
                System.out.println("choose the tool to change the level colors of the image");
                break;

            case "-rotate":
                command.add("-rotate");
                command.add(imageprocess.rotate(width_black));
                System.out.println("choose the tool to change the pixel of the image");
                break;

            case "":
                command.add("");
                System.out.println("No tool selected");
                break;

            default:
                System.out.println("It's not the process you are looking for");
        }

    }

    private void format(String fileName, String format) {
        switch (format) {

            case "png":
                command.add(fileName + ".png");
                break;

            case "gif":

                command.add(fileName + ".gif");
                break;
            case "tiff":

                command.add(fileName + ".tiff");
                break;
            case "jpg":

                command.add(fileName + ".jpg");
                break;
            case "webp":

                command.add(fileName + ".webp");
                break;
            case "pdf":

                command.add(fileName + ".pdf");
                break;
            default:
                System.out.println("the format it doesn't exit");
        }
    }

    @Override
    public void setParameters(List<String> setup) {

        processImage(setup.get(0));
        filepath(setup.get(1));
        tool(setup.get(2), setup.get(3), setup.get(4), setup.get(5));
        // tool(setup.get(6), setup.get(7), setup.get(8), setup.get(9));
        format(setup.get(6), setup.get(7));

    }

    @Override
    public List<String> getCommand() {
        System.out.println("comando final" + command);
        return command;
    }
}
