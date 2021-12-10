package com.treech.custom.viewstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends Activity {

    int x = 100;

    int y = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        FrameLayout container = new FrameLayout(this);
//        container.setLayoutParams(new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT));
//        container.addView(new MyView10(this));
//        setContentView(container);

        setContentView(R.layout.activity_main);
    }

    public void moveX(View view) {
        view.setTranslationX(x);
        x += 100;
    }

    public void moveY(View view) {
        view.setTranslationY(y);
        y += 100;
    }
}
