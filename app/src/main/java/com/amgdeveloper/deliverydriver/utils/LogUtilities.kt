package com.amgdeveloper.deliverydriver.utils

import android.util.Log
import com.amgdeveloper.deliverydriver.BuildConfig

/**
 * Created by amgdeveloper
 */
class LogUtilities {

    companion object {
        fun debug(tag: String, message: String) {
            if (BuildConfig.DEBUG)
                Log.d(tag, message)
        }
    }
}