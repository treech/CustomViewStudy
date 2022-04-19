package com.treech.custom.viewstudy.view.scaletype;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

import com.treech.custom.viewstudy.R;

public class ScaleTypeActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Button button;
    ImageView imageView;
    SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_type);
        imageView = findViewById(R.id.image);
        button = findViewById(R.id.switch_adjustBounds);
        seekBar = findViewById(R.id.seeKBar);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar.setMax(getResources().getDisplayMetrics().widthPixels);
        seekBar.setProgress(imageView.getWidth());
        button.setOnClickListener(this);
        setButtonText(imageView.getAdjustViewBounds());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_adjustBounds:
                switchAdjustBuounds();
                break;
        }
    }

    private void switchAdjustBuounds() {
        imageView.setAdjustViewBounds(!imageView.getAdjustViewBounds());
        setButtonText(imageView.getAdjustViewBounds());
    }

    private void setButtonText(boolean isAdjust) {
        button.setText("AdjustViewBounds = " + imageView.getAdjustViewBounds());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = progress;
        imageView.setLayoutParams(params);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
