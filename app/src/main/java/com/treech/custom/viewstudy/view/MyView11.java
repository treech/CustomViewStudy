package com.treech.custom.viewstudy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class MyView11 extends View {

    private int mWidth;
    private int mHeight;

    public MyView11(Context context) {
        this(context, null);
    }

    public MyView11(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView11(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         int baseLineX = 0;
         int baseLineY = 200;

         //画基线
         Paint paint = new Paint();
         paint.setAntiAlias(true);
         paint.setColor(Color.RED);
         canvas.drawLine(baseLineX, baseLineY, mWidth, baseLineY, paint);

         //写文字
         paint.setColor(Color.GREEN);
         paint.setTextSize(90); //以px为单位
         canvas.drawText("Android \'s Blog", baseLineX, baseLineY, paint);
         **/

        /**
         int baseLineX = 0;
         int baseLineY = 200;

         Paint paint = new Paint();
         paint.setColor(Color.GREEN);
         paint.setTextSize(90); //以px为单位
         paint.setTextAlign(Paint.Align.LEFT);
         canvas.drawText("Android \'s Blog", baseLineX, baseLineY, paint);

         //计算各线位置
         Paint.FontMetrics fontMetrics = paint.getFontMetrics();
         float ascent = baseLineY + fontMetrics.ascent;
         float descent = baseLineY + fontMetrics.descent;
         float top = baseLineY + fontMetrics.top;
         float bottom = baseLineY + fontMetrics.bottom;
         Log.d("tag", "-----fontMetrics.ascent=" + fontMetrics.ascent + "----fontMetrics.descent=" + fontMetrics.descent);
         Log.d("tag", "-----fontMetrics.ascent=" + fontMetrics.top + "----fontMetrics.descent=" + fontMetrics.bottom);

         //画基线
         paint.setColor(Color.RED);
         canvas.drawLine(baseLineX, baseLineY, mWidth, baseLineY, paint);

         //画top
         paint.setColor(Color.BLUE);
         canvas.drawLine(baseLineX, top, mWidth, top, paint);

         //画ascent
         paint.setColor(Color.GREEN);
         canvas.drawLine(baseLineX, ascent, mWidth, ascent, paint);

         //画descent
         paint.setColor(Color.YELLOW);
         canvas.drawLine(baseLineX, descent, mWidth, descent, paint);

         //画bottom
         paint.setColor(Color.RED);
         canvas.drawLine(baseLineX, bottom, mWidth, bottom, paint);
         **/

        Rect rect = new Rect(100, 100, 500, 500);//画一个矩形
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.BLUE);
        rectPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, rectPaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(50);
        textPaint.setStyle(Paint.Style.FILL);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();

//        int baseLineY = (int) (rect.centerY() +(bottom-top)/2-bottom);//基线中间点的y轴计算公式
        int baseLineY = (int) (rect.centerY() - (fontMetrics.ascent + fontMetrics.descent) / 2);//基线中间点的y轴计算公式

        canvas.drawText("Hello World!", rect.centerX(), baseLineY, textPaint);
    }
}
