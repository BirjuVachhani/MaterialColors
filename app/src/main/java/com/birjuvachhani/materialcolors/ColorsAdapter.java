package com.birjuvachhani.materialcolors;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.birjuvachhani.materialcolors.databinding.ColorsBinding;

import java.util.List;

/**
 * Created by birju.vachhani on 23/01/18.
 */

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder> {

    private List<ColorHolder> mcolorList;
    private LayoutInflater inflater;
    private IntentCallback callback;

    public ColorsAdapter(Context context, List<ColorHolder> mcolorList) {
        this.mcolorList = mcolorList;
        this.callback = (IntentCallback) context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ColorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ColorsBinding binding = ColorsBinding.inflate(inflater, parent, false);
        ColorsViewHolder holder = new ColorsViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ColorsViewHolder holder, int position) {

        ColorHolder colorHolder = mcolorList.get(position);

        holder.bind(colorHolder);
        holder.mbinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mcolorList.size();
    }

    class ColorsViewHolder extends RecyclerView.ViewHolder {
        ColorsBinding mbinding;

        public ColorsViewHolder(ColorsBinding binding) {
            super(binding.getRoot());
            this.mbinding = binding;

            this.mbinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    callback.showShades(mbinding.getColorholder());
                }
            });

        }

        public void bind(ColorHolder colorHolder) {

            mbinding.setColorholder(colorHolder);
        }
    }

    @BindingAdapter("backgroundColor")
    public static void setSrc(View view, String color) {

        int c = Color.parseColor("#2c2c2c");
        if (color != null) {
            try {
                c = Color.parseColor(color);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                view.setBackgroundColor(c);
            }
        }
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextView view, String color) {
        int c = Color.parseColor("#000000");
        if (color != null) {
            try {
                c = Color.parseColor(color);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                view.setTextColor(c);
            }
        }
    }

    interface IntentCallback {
        public void showShades(ColorHolder colorHolder);
    }

}
