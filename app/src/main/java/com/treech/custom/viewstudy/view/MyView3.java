package com.treech.custom.viewstudy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.treech.custom.viewstudy.R;

public class MyView3 extends View {
    public MyView3(Context context) {
        super(context);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);

        // 将画布坐标系移动到画布中央
        canvas.translate(getWidth() / 2, getHeight() / 2);

        // 指定图片绘制区域(左上角的四分之一)
        Rect src = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);

        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0, 0, 200, 400);

        // 绘制图片
        canvas.drawBitmap(bitmap, src, dst, null);
    }
}
