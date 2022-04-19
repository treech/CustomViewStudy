package com.treech.custom.viewstudy.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.treech.custom.viewstudy.R
import com.treech.custom.viewstudy.databinding.ActivityMainBinding
import com.treech.custom.viewstudy.ui.RippleDrawableActivity
import com.treech.custom.viewstudy.ui.ShadowActivity

class MainActivity : AppCompatActivity() {

    private val guideAdapter = GuideAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerView.adapter = guideAdapter
        val list = mutableListOf<String>()
        list.add("fillviewport")
        list.add("view shadow")
        list.add("ripple drawable")
        guideAdapter.submitData(list)
        guideAdapter.setClickAction { title, v, position ->
            when (position) {
                1 -> startActivity(Intent(this@MainActivity, ShadowActivity::class.java))
                2 -> startActivity(Intent(this@MainActivity, RippleDrawableActivity::class.java))
            }
        }
    }
}