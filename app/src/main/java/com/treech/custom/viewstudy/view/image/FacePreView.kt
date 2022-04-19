package com.treech.custom.viewstudy.view.image

import android.content.Context
import android.util.AttributeSet
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

class FacePreView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : View(context, attrs, defStyle) {


    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)





    override fun onDetachedFromWindow() {
        scope.cancel()
        super.onDetachedFromWindow()
    }

}