package com.jalasoft.springboothelloworld.model.converter;

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
