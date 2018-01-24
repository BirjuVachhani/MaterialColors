package com.birjuvachhani.materialcolors;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by birju.vachhani on 24/01/18.
 */

public class ShadeListGenerator {

    public static List<ShadeHolder> getShadeList(ColorHolder colorHolder) {
        String[] shadeColors = colorHolder.getShades();
        String[] shadeNames = colorHolder.getShadeNames();
        String[] shadeTextColors = colorHolder.getTextColors();
        List<ShadeHolder> mshadseList = new ArrayList<>();
        for (int i = 0; i < shadeColors.length && i < shadeNames.length; i++) {
            String shadeColor = shadeColors[i];
            String shadeName = shadeNames[i];
            String shadeTextColor = shadeTextColors[i];
            ShadeHolder shadeHolder = new ShadeHolder(shadeName, shadeColor, shadeTextColor);
            mshadseList.add(shadeHolder);
        }

        return mshadseList;
    }
}
