package com.amgdeveloper.deliverydriver.data.framework

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import com.amgdeveloper.deliverydriver.data.BatteryDataSource


/**
 * Created by amgdeveloper
 */
class BatteryDriver(private val context: Context) : BatteryDataSource {

    override fun getBatteryLevel(): Int {
        var result = -1

        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, intentFilter)

        if (batteryStatus != null) {
            val level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val percentage = level / scale.toFloat()
            result = (percentage * 100).toInt()
        }
        return result
    }
}