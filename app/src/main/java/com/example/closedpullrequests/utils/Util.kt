package com.example.closedpullrequests.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "Util"

private const val PARSING_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss'Z'"
private const val DATE_FORMAT = "dd MMM yyyy, hh:mm a"

fun getFormattedDate(data: String): String {
    return try {
        val sdf = SimpleDateFormat(PARSING_DATE_FORMAT, Locale.getDefault())
        val formatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        val date = sdf.parse(data)
        if (date != null) {
            formatter.format(date)
        } else {
            Log.e(TAG, "Couldn't format the date $data")
            ""
        }
    } catch (e: Exception) {
        Log.e(TAG, "", e)
        ""
    }
}
