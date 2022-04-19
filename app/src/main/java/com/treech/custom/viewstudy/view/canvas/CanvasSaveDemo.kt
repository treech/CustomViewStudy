package com.treech.custom.viewstudy.view.canvas

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.treech.custom.viewstudy.R

/**
 * 展示canvas.save和restore的使用
 */
class CanvasSaveDemo : View {

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

    private val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.GRAY)

        paint.color = Color.GREEN
        canvas.drawRect(0f,
            0f,
            width * 1.0f - paint.strokeWidth,
            height * 1.0f - paint.strokeWidth,
            paint)

        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        canvas.save()
        canvas.rotate(45f, width * 1.0f / 2, height * 1.0f / 2)

        paint.color = Color.RED
        canvas.drawRect(0f,
            0f,
            width * 1.0f - paint.strokeWidth,
            height * 1.0f - paint.strokeWidth,
            paint)

        canvas.drawBitmap(bitmap,
            (width - bitmap.width) * 1.0f / 2,
            (height - bitmap.height) * 1.0f / 2,
            paint)

        canvas.restore()

        canvas.drawRect(0f,
            0f,
            width * 0.25f - paint.strokeWidth,
            height * 0.25f - paint.strokeWidth,
            paint)

        canvas.drawBitmap(bitmap,
            width * 0.25f - bitmap.width,
            height * 0.25f - bitmap.height,
            paint)
    }
}