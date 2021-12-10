package com.treech.custom.viewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView7 extends View {

    private int mWidth;
    private int mHeight;

    public MyView7(Context context) {
        super(context);
    }

    public MyView7(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView7(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mPaint = new Paint();             // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(4);              // 边框宽度 - 10

        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)
        canvas.scale(1f, -1f);

        // x轴
        canvas.drawLine(-mWidth / 2f, 0f, mWidth / 2f, 0f, mPaint);
        // y轴
        canvas.drawLine(0f, -mHeight / 2f, 0f, mHeight / 2f, mPaint);

        //x轴箭头
        canvas.drawLine(mWidth / 2f - 20, 20, mWidth / 2f, 0f, mPaint);

        canvas.drawLine(mWidth / 2f - 20, -20, mWidth / 2f, 0f, mPaint);

        //y轴箭头
        canvas.drawLine(20f, mHeight / 2f - 20, 0f, mHeight / 2f, mPaint);

        canvas.drawLine(-20f, mHeight / 2f - 20, 0f, mHeight / 2f, mPaint);
        mPaint.setTextSize(30f);
        canvas.drawText("Y", 30, mHeight / 2f - 30, mPaint);

        mPaint.setTextSize(30f);

        canvas.drawText("X", mWidth / 2f - 50, 60, mPaint);

        mPaint.setColor(Color.RED);

        Path path = new Path();
        path.lineTo(100,100);

        RectF oval = new RectF(0,0,300,300);

        path.arcTo(oval,0,270);
        // path.arcTo(oval,0,270,true);             // <-- 和上面一句作用等价

        canvas.drawPath(path, mPaint);              // 绘制Path
    }
}
