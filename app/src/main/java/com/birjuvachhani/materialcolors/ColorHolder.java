package com.birjuvachhani.materialcolors;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by birju.vachhani on 23/01/18.
 */

public class ColorHolder extends BaseObservable implements Parcelable {
    private String colorLabel; //color name labels in camelCase for using in code. ex. lightBlue
    private String colorName; //original name of color with spaces. ex. light blue
    private String[] shades;
    private String[] shadeNames;
    private String[] textColors;
    private String mainColor;
    private String mainTextColor;

    public ColorHolder(String colorLabel, String colorName, String[] shades, String[] shadeNames, String[] textColors) {
        this.colorLabel = colorLabel;
        this.colorName = colorName;
        this.shades = shades;
        this.shadeNames = shadeNames;
        this.textColors = textColors;
        this.mainColor = shades[5];
        this.mainTextColor = textColors[5];
    }

    protected ColorHolder(Parcel in) {
        colorLabel = in.readString();
        colorName = in.readString();
        shades = in.createStringArray();
        shadeNames = in.createStringArray();
        textColors = in.createStringArray();
        mainColor = in.readString();
        mainTextColor = in.readString();
    }

    public static final Creator<ColorHolder> CREATOR = new Creator<ColorHolder>() {
        @Override
        public ColorHolder createFromParcel(Parcel in) {
            return new ColorHolder(in);
        }

        @Override
        public ColorHolder[] newArray(int size) {
            return new ColorHolder[size];
        }
    };

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


    public String getMainColor() {
        return mainColor;
    }

    public String getMainTextColor() {
        return mainTextColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(colorLabel);
        dest.writeString(colorName);
        dest.writeStringArray(shades);
        dest.writeStringArray(shadeNames);
        dest.writeStringArray(textColors);
        dest.writeString(mainColor);
        dest.writeString(mainTextColor);
    }
}
