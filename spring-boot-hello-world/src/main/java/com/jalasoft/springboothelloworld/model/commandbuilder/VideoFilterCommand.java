package com.jalasoft.springboothelloworld.model.commandbuilder;

import java.util.List;

public class VideoFilterCommand {
    private boolean thereIsVf = false;
    private String vfCommand = "";

    public VideoFilterCommand(List<String> vfsetings) {
        buildVfCommand(vfsetings);
    }
    private void buildVfCommand(List<String> vfsetings) {
        for (int index = 0; index < vfsetings.size(); index++) {
            if (!vfsetings.get(index).equals("")) {
                if (thereIsVf) {
                    vfCommand += ",";
                }
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
            thereIsVf = true;
        }
    }
    private void vfSetFPS(int fps) {
        vfCommand += "fps=" + fps;
        thereIsVf = true;
    }
    private void vfSetColor(double color) {
        vfCommand += "\"hue=s=" + color + "\""; // -vf "hue=s=0"
        thereIsVf = true;
    }
    private void vfResize(int width, int height) {
        vfCommand += "scale=" + width + ":" + height + ":force_original_aspect_ratio=decrease,pad="  + width + ":" + height + ":-1:-1:color=black";
        thereIsVf = true;
    }
    private void vfCropVideo(int width, int height, int posX, int posY) {
        vfCommand +="crop=" + width + ":" + height + ":" + posX + ":" + posY;
        thereIsVf = true;
    }
    public String getCommandText() {
        return vfCommand;
    }
}
