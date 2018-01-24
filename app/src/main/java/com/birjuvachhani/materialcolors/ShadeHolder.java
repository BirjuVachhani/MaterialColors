package com.birjuvachhani.materialcolors;

/**
 * Created by birju.vachhani on 24/01/18.
 */

public class ShadeHolder {

    private String shadeColor;
    private String shadeName;
    private String shadeTextColor;

    public ShadeHolder(String shadeName, String shadeColor, String shadeTextColor) {

        this.shadeColor = shadeColor;
        this.shadeName = shadeName;
        this.shadeTextColor=shadeTextColor;
    }

    public String getShadeColor() {
        return shadeColor;
    }

    public String getShadeName() {
        return shadeName;
    }

    public String getShadeTextColor() {
        return shadeTextColor;
    }
}
