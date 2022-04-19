package com.treech.custom.viewstudy.view.image;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.treech.custom.viewstudy.R;

public class ShowBigImageActivity extends AppCompatActivity {

    private MyMatrixImg myMatrixImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big_imgae);
        myMatrixImg = findViewById(R.id.img_beauty);
    }

    public void rotate(View view) {
        myMatrixImg.rotation(90);
    }
}
