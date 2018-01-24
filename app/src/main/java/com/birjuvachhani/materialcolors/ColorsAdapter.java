package com.birjuvachhani.materialcolors;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.birjuvachhani.materialcolors.databinding.ColorsBinding;

import java.util.List;

/**
 * Created by birju.vachhani on 23/01/18.
 */

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder> {

    private Context context;
    private List<ColorHolder> mcolorList;
    private LayoutInflater inflater;

    public ColorsAdapter(Context context, List<ColorHolder> mcolorList) {
        this.context = context;
        this.mcolorList = mcolorList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ColorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ColorsBinding binding = ColorsBinding.inflate(inflater, parent, false);
        ColorsViewHolder holder = new ColorsViewHolder(context, binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ColorsViewHolder holder, int position) {

        ColorHolder colorHolder = mcolorList.get(position);

        holder.bind(colorHolder);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mcolorList.size();
    }

    class ColorsViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        ColorsBinding binding;

        public ColorsViewHolder(Context context, ColorsBinding binding) {
            super(binding.getRoot());
            this.context = context;
            this.binding = binding;
        }

        public void bind(ColorHolder colorHolder) {
            binding.setColorholder(colorHolder);
        }
    }

    @BindingAdapter("backgroundColor")
    public static void setSrc(LinearLayout layout, String color) {

        int c = Color.parseColor("#2c2c2c");
        if (color != null) {
            try {
                c = Color.parseColor(color);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                layout.setBackgroundColor(c);
            }
        }
    }

    @BindingAdapter("textColor")
    public static void setTextColor(TextView view, String color) {
        int c = Color.parseColor("#FFFFFF");
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
}
