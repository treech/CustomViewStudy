package com.treech.custom.viewstudy.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.treech.custom.viewstudy.R
import com.treech.custom.viewstudy.view.drawable.CustomRippleDrawable


class RippleDrawableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ripple_drawable)
        val mTvSystem = findViewById<TextView>(R.id.tv_system)
        val mTvCustom = findViewById<TextView>(R.id.tv_custom)
        val tvXml = findViewById<TextView>(R.id.tv_xml)
        mTvSystem.setOnClickListener({ v: View? -> })
        mTvCustom.setOnClickListener({ v: View? -> })
        tvXml.setOnClickListener({ v: View? -> })
        mTvCustom.background = CustomRippleDrawable()
    }
}