package com.treech.custom.viewstudy.view

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.treech.custom.viewstudy.*

/**
 * https://juejin.cn/post/6844903542919004173
 */
class MyTextView2 @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) :
    View(context, attr, defStyleAttr) {

    companion object {
        const val TAG = "MyTextView2"
    }

    init {
        initView(context, attr, defStyleAttr)
    }

    private fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {


        val density = Resources.getSystem().displayMetrics.density
        val density2 = resources.displayMetrics.density
        Log.d(TAG, "density:$density,density2:$density2")


        val ta = context.obtainStyledAttributes(attrs, R.styleable.MyTextView2, defStyleAttr, 0)
        val textSize = ta.getDimension(R.styleable.MyTextView2_text_size, dp2pxFloat(30)).toInt()
        val dpFromXml = resources.getDimension(R.dimen.dp_30)
        val dpFromXmlPixel = resources.getDimensionPixelSize(R.dimen.dp_30)
        val dpFromXmlOffset = resources.getDimensionPixelOffset(R.dimen.dp_30)
        Log.d(TAG,
            "textSize:$textSize,dpFromXml:$dpFromXml,dpFromXmlPixel:$dpFromXmlPixel,dpFromXmlOffset:$dpFromXmlOffset")

        val spFromXml = resources.getDimension(R.dimen.sp_30)
        val spFromXmlPixel = resources.getDimensionPixelSize(R.dimen.sp_30)
        val spFromXmlOffset = resources.getDimensionPixelOffset(R.dimen.sp_30)
        Log.d(TAG,
            "spFromXml:$spFromXml,spFromXmlPixel:$spFromXmlPixel,spFromXmlOffset:$spFromXmlOffset")

        val pxFromXml = resources.getDimension(R.dimen.sp_30)
        val pxFromXmlPixel = resources.getDimensionPixelSize(R.dimen.sp_30)
        val pxFromXmlOffset = resources.getDimensionPixelOffset(R.dimen.sp_30)
        Log.d(TAG,
            "pxFromXml:$pxFromXml,pxFromXmlPixel:$pxFromXmlPixel,pxFromXmlOffset:$pxFromXmlOffset")

        val dp2pxFromCode = dp2px(30)
        val sp2pxFromCode = sp2px(30)
        val px2dpFromCode = px2dp(30)
        Log.d(TAG,
            "dp2pxFromCode:$dp2pxFromCode,sp2pxFromCode:$sp2pxFromCode,px2dpFromCode:$px2dpFromCode")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val colorValue = ContextCompat.getColor(context, R.color.colorB2FFFFFF)

        Log.d(TAG,"colorValue:$colorValue")

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
//        paint.color = Color.GRAY
        paint.color = colorValue
        val textWidth = paint.measureText("YangLe'Blog'")
        val baseLineY = Math.abs(paint.descent() + paint.ascent()) / 2
        canvas.drawText("YangLe'Blog'", -textWidth / 2, baseLineY, paint)
    }
}