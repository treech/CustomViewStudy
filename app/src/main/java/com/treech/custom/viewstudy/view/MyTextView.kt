package com.treech.custom.viewstudy.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * https://juejin.cn/post/6844903542919004173
 */
class MyTextView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attr: AttributeSet) : super(context, attr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        // 将坐标原点移到控件中心
        canvas.translate(width / 2f, height / 2f)
        // x轴
        canvas.drawLine(-width / 2f, 0f, width / 2f, 0f, paint)
        // y轴
        canvas.drawLine(0f, -height / 2f, 0f, height / 2f, paint)

        // 绘制文字
        paint.textSize = 50f
        paint.color = Color.GRAY
        val textWidth = paint.measureText("YangLe'Blog'")
        val baseLineY = -(paint.descent() + paint.ascent()) / 2
        canvas.drawText("YangLe'Blog'", -textWidth / 2, baseLineY, paint)
    }
}