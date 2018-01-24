package com.birjuvachhani.materialcolors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.birjuvachhani.materialcolors.databinding.ShadesBinding;

import java.util.List;

/**
 * Created by birju.vachhani on 24/01/18.
 */

public class ShadesAdapter extends RecyclerView.Adapter<ShadesAdapter.ShadesViewHolder> {

    private List<ShadeHolder> mshadeList;
    private LayoutInflater inflater;
    private CopyCallback copyCallback;

    public ShadesAdapter(Context context, List<ShadeHolder> mshadeList) {
        this.mshadeList = mshadeList;
        this.copyCallback = (CopyCallback) context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ShadesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ShadesBinding binding = ShadesBinding.inflate(inflater, parent, false);
        ShadesViewHolder holder = new ShadesViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShadesViewHolder holder, int position) {

        ShadeHolder shadeHolder = mshadeList.get(position);
        holder.bind(shadeHolder);
        holder.mbinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return mshadeList.size();
    }

    class ShadesViewHolder extends RecyclerView.ViewHolder {

        ShadesBinding mbinding;

        public ShadesViewHolder(ShadesBinding binding) {
            super(binding.getRoot());
            this.mbinding = binding;

            this.mbinding.getRoot().setLongClickable(true);
            this.mbinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    copyCallback.copyColor(mbinding.getShadeholder().getShadeColor());
                    return true;
                }
            });
        }

        public void bind(ShadeHolder shadeHolder) {
            mbinding.setShadeholder(shadeHolder);
        }
    }

    interface CopyCallback {
        public void copyColor(String color);
    }

}
