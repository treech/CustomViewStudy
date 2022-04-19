package com.treech.custom.viewstudy.view.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.treech.custom.viewstudy.R;

public class ClipRectView extends View {

    private Bitmap mBitmap = null;
    private int limitLength = 0;
    private int width;
    private int heigth;
    private Paint mPaint;
    private static final int CLIP_HEIGHT = 50;

    public ClipRectView(Context context) {
        this(context, null);
    }

    public ClipRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        limitLength = width = mBitmap.getWidth();
        heigth = mBitmap.getHeight();
    }

    public ClipRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(60);

        canvas.translate(300, 300);

        //设置显示范围
        canvas.clipRect(100, 100, 500, 300);

        //白色背景
        canvas.drawColor(Color.WHITE);

        //绘制字符串
        canvas.drawText("简单教程，简单编程", 150, 300, mPaint);
        invalidate();
    }
}
