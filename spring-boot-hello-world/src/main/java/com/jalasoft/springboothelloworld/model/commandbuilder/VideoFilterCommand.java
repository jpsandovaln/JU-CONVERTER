/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package com.jalasoft.springboothelloworld.model.commandbuilder;

import java.util.List;

/**
 * It is responsible for assembling the text for add the video filters to the video convert command.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class VideoFilterCommand {
    private boolean thereIsVf = false;
    private String vfCommand = "";

    public VideoFilterCommand(List<String> vfsetings) {
        buildVfCommand(vfsetings);
    }
    private void buildVfCommand(List<String> vfsetings) {
        for (int index = 0; index < vfsetings.size(); index++) {
            if (!vfsetings.get(index).equals("")) {
                vfCommand += thereIsVf ? "," : "";
                switch(index) {
                    case 0:
                        vfRotateVideo(Integer.parseInt(vfsetings.get(index)));
                        break;
                    case 1:
                        vfSetFPS(Integer.parseInt(vfsetings.get(index)));
                        break;
                    case 2:
                        vfSetColor(Double.parseDouble(vfsetings.get(index)));
                        break;
                    case 3:
                        String[] size = vfsetings.get(index).split("x");
                        vfResize(Integer.parseInt(size[0]),Integer.parseInt(size[1]));
                        break;
                    case 4:
                        String[] crop = vfsetings.get(index).split(":");
                        vfCropVideo(Integer.parseInt(crop[0]),Integer.parseInt(crop[1]),
                                    Integer.parseInt(crop[2]), Integer.parseInt(crop[3]));
                        break;
                }
                thereIsVf = true;
            }
        }
    }
    private void vfRotateVideo(int angle) {
        for (int rotate = 1; rotate <= angle/90; rotate ++) {
            if (thereIsVf) {
                vfCommand += ",";
            }
            vfCommand += "transpose=clock";
        }
    }
    private void vfSetFPS(int fps) {
        vfCommand += "fps=" + fps;
    }
    private void vfSetColor(double color) {
        vfCommand += "\"hue=s=" + color + "\""; // -vf "hue=s=0"
    }
    private void vfResize(int width, int height) {
        vfCommand += "scale=" + width + ":" + height + ":force_original_aspect_ratio=decrease,pad="  + width + ":" + height + ":-1:-1:color=black";
    }
    private void vfCropVideo(int width, int height, int posX, int posY) {
        vfCommand +="crop=" + width + ":" + height + ":" + posX + ":" + posY;
    }
    public String getCommandText() {
        return vfCommand;
    }
}
