package com.treech.custom.viewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView4 extends View {

    private int mWidth;
    private int mHeight;

    public MyView4(Context context) {
        super(context);
    }

    public MyView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10

        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心(宽高数据在onSizeChanged中获取)

        // x轴
        canvas.drawLine(-mWidth / 2f, 0f, mWidth / 2f, 0f, mPaint);
        // y轴
        canvas.drawLine(0f, -mHeight / 2f, 0f, mHeight / 2f, mPaint);

        mPaint.setColor(Color.RED);
        Path path = new Path();                     // 创建Path

        path.lineTo(200, 200);                      // lineTo

        path.lineTo(200,0);                         // lineTo

        path.close();

        canvas.drawPath(path, mPaint);              // 绘制Path
    }
}
