package com.birjuvachhani.materialcolors;

/**
 * Created by birju.vachhani on 23/01/18.
 */

public class ColorHolder {
    private String colorLabel; //color name labels in camelCase for using in code. ex. lightBlue
    private String colorName; //original name of color with spaces. ex. light blue
    private String[] shades;
    private String[] shadeNames;
    private String[] textColors;


    public ColorHolder(String colorLabel, String colorName, String[] shades, String[] shadeNames, String[] textColors) {
        this.colorLabel = colorLabel;
        this.colorName=colorName;
        this.shades = shades;
        this.shadeNames = shadeNames;
        this.textColors = textColors;
    }

    public String getColorLabel() {
        return colorLabel;
    }

    public String[] getShades() {
        return shades;
    }

    public String[] getShadeNames() {
        return shadeNames;
    }

    public String[] getTextColors() {
        return textColors;
    }

    public String getColorName() {
        return colorName;
    }
}
