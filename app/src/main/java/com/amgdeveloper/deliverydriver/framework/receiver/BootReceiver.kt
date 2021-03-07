package com.amgdeveloper.deliverydriver.framework.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.amgdeveloper.deliverydriver.common.app
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

/**
 * Created by amgdeveloper
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        MainScope().launch {
            context?.applicationContext?.app?.trackingController?.startTracking()
        }
    }
}