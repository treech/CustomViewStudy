package com.treech.custom.viewstudy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.treech.custom.viewstudy.R
import com.treech.custom.viewstudy.databinding.ActivityShadowBinding

class ShadowActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityShadowBinding>(this, R.layout.activity_shadow)
    }
}