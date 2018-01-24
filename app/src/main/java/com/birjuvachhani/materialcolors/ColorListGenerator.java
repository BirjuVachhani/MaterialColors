package com.birjuvachhani.materialcolors;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by birju.vachhani on 23/01/18.
 */

public class ColorListGenerator {
    String[] colorLabels;
    String[] colorNames;
    String[] shadeNames;

    private int[] colorShades = {R.array.red_colors, R.array.pink_colors, R.array.purple_colors, R.array.deepPurple_colors, R.array.indigo_colors,
            R.array.blue_colors, R.array.lightBlue_colors, R.array.cyan_colors, R.array.teal_color, R.array.green_colors, R.array.lightGreen_colors,
            R.array.lime_color, R.array.yellow_colors, R.array.amber_colors, R.array.orange_colors, R.array.deepOrange_colors, R.array.brown_colors,
            R.array.grey_colors, R.array.blueGrey_colors};

    private int[] textColors = {R.array.red_text_colors, R.array.pink_text_colors, R.array.purple_text_colors, R.array.deepPurple_text_colors, R.array.indigo_text_colors,
            R.array.blue_text_colors, R.array.lightBlue_text_colors, R.array.cyan_text_colors, R.array.teal_text_colors, R.array.green_text_colors, R.array.lightGreen_text_colors,
            R.array.lime_text_colors, R.array.yellow_text_colors, R.array.amber_text_colors, R.array.orange_text_colors, R.array.deepOrange_text_colors, R.array.brown_text_colors,
            R.array.grey_text_colors, R.array.blueGrey_text_colors};

    Context context;

    public ColorListGenerator(Context context) {
        this.context = context;
        this.colorLabels = context.getResources().getStringArray(R.array.color_labels);
        this.colorNames = context.getResources().getStringArray(R.array.color_list);
        this.shadeNames = context.getResources().getStringArray(R.array.shade_names);
    }

    protected List<ColorHolder> getColorList() {
        List<ColorHolder> mlist = new ArrayList<>();
        for (int i = 0; i < colorLabels.length; i++) {
            String colorLabel = colorLabels[i];
            String colorName = colorNames[i];
            String[] shades = context.getResources().getStringArray(colorShades[i]);
            String[] text = context.getResources().getStringArray(textColors[i]);

            ColorHolder colorHolder = new ColorHolder(colorLabel, colorName, shades, shadeNames, text);
            mlist.add(colorHolder);
        }
        return mlist;
    }
}
