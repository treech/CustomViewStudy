package com.treech.custom.viewstudy.view.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 展示canvas.rotate的使用
 */
class CanvasRotateDemo : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet) : super(context, attr)

    private val paint by lazy {
        Paint().apply {
            isDither = true
            isAntiAlias = true
            strokeWidth = 2.0f
            style = Paint.Style.STROKE
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.GRAY)

        paint.color = Color.YELLOW
        canvas.drawRect(width * 0.5f, height * 0.5f, width * 0.9f, height * 0.9f, paint)

        canvas.rotate(45f, width * 1.0f / 2, height * 1.0f / 2)

        paint.color = Color.RED
        canvas.drawRect(width * 0.5f, height * 0.5f, width * 0.9f, height * 0.9f, paint)

        canvas.rotate(20f, width * 1.0f / 2, height * 1.0f / 2)

        paint.color = Color.GREEN
        canvas.drawRect(width*0.5f, height*0.5f, width * 0.9f, height * 0.9f, paint)
    }
}