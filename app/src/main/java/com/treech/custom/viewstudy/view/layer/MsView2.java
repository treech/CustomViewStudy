package com.treech.custom.viewstudy.view.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Android Canvas Layer 图层
 * https://www.twle.cn/l/yufei/android/android-basic-canvas-layer.html
 */
public class MsView2 extends AppCompatImageView {

    public MsView2(Context context) {

        super(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();

        Paint mPaint = new Paint();
        mPaint.setColor(0xffff0000);
        mPaint.setTextSize(48);

        canvas.translate(300, 300);
        canvas.drawText("简单教程，简单编程",0,0,mPaint);
        canvas.save();

        canvas.rotate(45);
        canvas.drawText("简单教程，简单编程",0,0,mPaint);
        canvas.save();

        canvas.rotate(45);
        canvas.drawText("简单教程，简单编程",0,0,mPaint);
        canvas.save();

        canvas.restore();
        canvas.restore();
        canvas.restore();
        canvas.restore();

        canvas.translate(0, 200);
        canvas.drawText("简单教程，简单编程",0,0,mPaint);

        invalidate();
    }
}
