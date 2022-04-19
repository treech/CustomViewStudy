package com.treech.custom.viewstudy.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View

class OnMeasureView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet) : super(context, attr)
    constructor(context: Context?, attr: AttributeSet, defStyleAttr: Int) : super(context,
        attr,
        defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMode)
        val heightSize = MeasureSpec.getSize(heightMode)

        Log.d(TAG,
            "onMeasure widthMode:$widthMode,heightMode:$heightMode,widthSize:$widthSize,heightSize:$heightSize")

        Log.d(TAG,
            "onMeasure AT_MOST:${MeasureSpec.AT_MOST},UNSPECIFIED:${MeasureSpec.UNSPECIFIED},EXACTLY:${MeasureSpec.EXACTLY}")

        val result = 200

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(result, result)
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(result, heightSize)
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, result)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.RED)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.d(TAG, "w:$w,h:$h,oldw:$oldw,oldh:$oldh")
    }

    companion object {
        private const val TAG = "OnMeasureView"
    }
}