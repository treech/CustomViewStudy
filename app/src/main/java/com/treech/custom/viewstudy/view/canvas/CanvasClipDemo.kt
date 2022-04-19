package com.treech.custom.viewstudy.view.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.treech.custom.viewstudy.R

/**
 * 展示canvas.clipRect的使用
 */
class CanvasClipDemo : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet) : super(context, attr)

    private val paint by lazy {
        Paint().apply {
            isDither = true
            isAntiAlias = true
            strokeWidth = 2.0f
            style = Paint.Style.FILL
            color = Color.YELLOW
        }
    }

    private val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.GRAY)

        val rect = RectF(0f, 0f, width * 0.5f, height * 0.5f)

        canvas.clipRect(rect)
        canvas.drawRect(rect, paint)

        val rect2 = RectF(width * 0.25f, height * 0.25f, width * 0.75f, height * 0.75f)
        paint.color = Color.GREEN
        canvas.drawRect(rect2, paint)

        val rect3 = RectF(width * 0.5f, height * 0.5f, width * 1.0f, height * 1.0f)
        paint.color = Color.RED
        canvas.drawRect(rect3, paint)
    }
}