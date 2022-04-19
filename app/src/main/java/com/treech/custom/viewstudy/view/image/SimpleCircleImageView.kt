package com.treech.custom.viewstudy.view.image

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.treech.custom.viewstudy.R
import com.treech.custom.viewstudy.dp2Px

class SimpleCircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatImageView(context, attrs, defStyle) {

    //描边颜色
    private var borderStrokeColor = Color.parseColor("#DFDFE0")

    //描边宽度
    private var borderStrokeWidth: Float = dp2Px(1)

    private val borderStrokePaint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = borderStrokeWidth
            color = borderStrokeColor
        }
    }

    init {
        handleAttributes(context, attrs)
        initAttributes()
    }

    private fun initAttributes() {
        borderStrokePaint.strokeWidth = borderStrokeWidth
        borderStrokePaint.color = borderStrokeColor
    }

    private fun handleAttributes(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.SimpleCircleImageView).apply {
            borderStrokeColor = getColor(R.styleable.SimpleCircleImageView_scBorderStrokeColor, ContextCompat.getColor(context, R.color.colorDFDFE0))
            borderStrokeWidth = getDimension(R.styleable.SimpleCircleImageView_scBorderStrokeWidth, dp2Px(1))
            recycle()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width > height) {
            val radius = height * 0.5f
            canvas.drawCircle(width * 0.5f, radius, radius - borderStrokeWidth * 0.5f, borderStrokePaint)
        } else {
            val radius = width * 0.5f
            canvas.drawCircle(radius, height * 0.5f, radius - borderStrokeWidth * 0.5f, borderStrokePaint)
        }
    }
}