package com.treech.custom.viewstudy.view.layer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.treech.custom.viewstudy.R;
import com.treech.custom.viewstudy.view.MyTextView;
import com.treech.custom.viewstudy.view.MyView11;
import com.treech.custom.viewstudy.view.OnMeasureView;

public class CanvasLayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new MsView2(this));
//        setContentView(new MyTextView(this));
        setContentView(R.layout.activity_temp);
//        setContentView(new MyView11(this));
    }
}
