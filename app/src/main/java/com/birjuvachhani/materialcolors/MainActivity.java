package com.birjuvachhani.materialcolors;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.birjuvachhani.materialcolors.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ColorListGenerator colorListGenerator = new ColorListGenerator(MainActivity.this);
        List<ColorHolder> mcolorList = colorListGenerator.getColorList();

        ColorsAdapter adapter = new ColorsAdapter(MainActivity.this, mcolorList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }
}
