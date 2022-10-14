package com.jalasoft.springboothelloworld.response;

public class ImageUploadResponse {
    private String process;
    private String file;
    private String tool;
    private String width_black;
    private String height_white;
 //   private String toolcolor;
    private String color;
    private String fileout;
    private String format;


    public ImageUploadResponse(String process, String file, String tool, String width_black, String height_white, String color, String fileout, String format) { //String toolcolor
        this.process = process;
        this.file = file;
        this.tool = tool;
        this.width_black = width_black;
        this.height_white = height_white;
       // this.toolcolor = toolcolor;
        this.color = color;
        this.fileout = fileout;
        this.format = format;
    }


    public String getProcess() {
        return process;
    }


    public void setProcess(String process) {
        this.process = process;
    }


    public String getFile() {
        return file;
    }


    public void setFile(String file) {
        this.file = file;
    }


    public String getTool() {
        return tool;
    }


    public void setTool(String tool) {
        this.tool = tool;
    }


    public String getWidth_black() {
        return width_black;
    }


    public void setWidth_black(String width_black) {
        this.width_black = width_black;
    }


    public String getHeight_white() {
        return height_white;
    }


    public void setHeight_white(String height_white) {
        this.height_white = height_white;
    }

    //public String gettoolcolor() {
    //    return toolcolor;
    //}


   // public void settoolcolor(String toolcolor) {
   //     this.toolcolor = toolcolor;
   // }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public String getFileout() {
        return fileout;
    }


    public void setFileout(String fileout) {
        this.fileout = fileout;
    }


    public String getFormat() {
        return format;
    }


    public void setFormat(String format) {
        this.format = format;
    }


}
