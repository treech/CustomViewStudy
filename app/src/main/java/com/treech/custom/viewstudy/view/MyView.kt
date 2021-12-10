package com.treech.custom.viewstudy.view

import android.content.Context
import android.graphics.*
import android.view.View
import com.treech.custom.viewstudy.R

class MyView constructor(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 首先定义一个paint
        val paint = Paint()
        paint.color = Color.RED
        // 设置样式-空心矩形
        paint.style = Paint.Style.STROKE
        // 绘制一个矩形
        canvas.drawRect(150f, 75f, 250f, 120f, paint)
        paint.color = Color.YELLOW
        canvas.drawRect(250f, 75f, 350f, 120f, paint)
        paint.color = Color.GREEN
        canvas.drawRect(150f, 120f, 250f, 170f, paint)
        paint.color = Color.CYAN
        canvas.drawRect(250f, 120f, 350f, 170f, paint)

        // 绘文字
        // 设置颜色
        paint.color = Color.BLACK

        val rect = Rect()
        paint.getTextBounds("Hello1", 0, "Hello1".length, rect)
        // 绘文字
        canvas.drawText(
            "Hello1",
            150f + (250 - 150) / 2 - rect.width() / 2,
            75f + (120 - 75) / 2 + rect.height() / 2,
            paint
        )
        canvas.drawText("Hello2", 300f, 100f, paint)
        canvas.drawText("Hello3", 200f, 150f, paint)
        canvas.drawText("Hello4", 300f, 170f, paint)

        // 绘图
        // 从资源文件中生成位图
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.test)

        // 绘图
        canvas.drawBitmap(bitmap, 270f, 140f, paint)
    }
}