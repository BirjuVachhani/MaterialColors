package com.birjuvachhani.materialcolors;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.birjuvachhani.materialcolors.databinding.ShadesActivityBinding;

import java.util.List;

public class ShadesActivity extends AppCompatActivity implements ShadesAdapter.CopyCallback {

    ColorHolder colorHolder;
    private ShadesActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_shades);

        colorHolder = getIntent().getParcelableExtra(Constants.PARCEL_LABEL);
        binding.setColorholder(colorHolder);
        binding.executePendingBindings();

        changeStatusBarColor();
        if(colorHolder.getMainTextColor().equals("Black"))
        {
            setTheme(R.style.AppTheme3);
        }

        binding.toolbar.setBackgroundColor(Color.parseColor(colorHolder.getMainColor()));
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<ShadeHolder> mshadeList = ShadeListGenerator.getShadeList(colorHolder);

        ShadesAdapter adapter = new ShadesAdapter(this, mshadeList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);

    }

    protected void changeStatusBarColor() {
        String[] shades = colorHolder.getShades();
        int color = Color.parseColor(shades[7]);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            getWindow().setStatusBarColor(color);
        }

    }

    @Override
    public void copyColor(String color) {

        if(copyToClipBoard(color)) {
            displayMessage(Constants.TEXT_COPY);
        }
        else
        {
            displayMessage(Constants.TEXT_ERROR);
        }
    }

    public Boolean copyToClipBoard(String color)
    {
        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip=ClipData.newPlainText(Constants.CLIP_LABEL,color);
        clipboardManager.setPrimaryClip(clip);
        return true;
    }

    public void displayMessage(String message)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Snackbar.make(binding.getRoot(), message, Snackbar.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
