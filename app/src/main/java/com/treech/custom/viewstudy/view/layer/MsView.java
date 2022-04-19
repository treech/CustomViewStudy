package com.treech.custom.viewstudy.view.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Android Canvas Layer 图层
 * https://www.twle.cn/l/yufei/android/android-basic-canvas-layer.html
 */
public class MsView extends AppCompatImageView {

    public MsView(Context context) {

        super(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        Paint mPaint = new Paint();

        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);// 抗锯尺
        mPaint.setColor(0xffff0000);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.save();  //保存当前 canvas 的状态

        canvas.translate(100, 100);
        canvas.drawRect(200, 200, 200 + 300, 200 + 200, mPaint);

        canvas.restore();  //恢复保存的Canvas的状态
        mPaint.setColor(0xff00ff00);
        canvas.drawRect(100, 100, 100 + 300, 100 + 200, mPaint);

        invalidate();
    }
}
