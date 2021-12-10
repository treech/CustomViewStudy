package com.treech.custom.viewstudy

import android.content.res.Resources

import android.content.Context
import android.util.TypedValue

val screenWidth: Int
    get() = Resources.getSystem().displayMetrics.widthPixels

val screenHeight: Int
    get() = Resources.getSystem().displayMetrics.heightPixels

fun px2dp(pxValue: Int): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun dp2px(dipValue: Int): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (dipValue * scale + 0.5f).toInt()
}

fun sp2px(dipValue: Int): Int {
    val scale = Resources.getSystem().displayMetrics.scaledDensity
    return (dipValue * scale + 0.5f).toInt()
}

fun dp2pxFloat(dipValue: Int): Float {
    val scale = Resources.getSystem().displayMetrics.density
    return dipValue * scale + 0.5f
}

inline fun <reified T> dp2Px(dpValue: Int): T {
    val result = Resources.getSystem().displayMetrics.density * dpValue + 0.5f
    return when (T::class) {
        Int::class -> result.toInt() as T
        Float::class -> result as T
        else -> throw IllegalStateException("Type not support.")
    }
}

fun getActionBarHeight(context: Context): Int {
    val typedValue = TypedValue()
    return if (context.theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)) {
        return TypedValue.complexToDimensionPixelSize(
            typedValue.data,
            context.resources.displayMetrics
        )
    } else {
        0
    }
}

fun getStatusBarHeight(context: Context): Int {
    var result = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = context.resources.getDimensionPixelSize(resourceId)
    }
    return result
}

fun getNavigationBarHeight(context: Context): Int {
    val resources = context.resources
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    //获取NavigationBar的高度
    return resources.getDimensionPixelSize(resourceId)
}

