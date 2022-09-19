package com.example.closedpullrequests.utils

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun Context.toDp(value: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(),
        resources.displayMetrics
    ).roundToInt()
}
