package com.amgdeveloper.deliverydriver.framework.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.LocationResult

/**
 * Created by amgdeveloper
 */
class LocationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val results = LocationResult.extractResult(intent)
        if (results != null) {
            val locations = results.locations
            for (loc in locations) {
                //TODO: process locations
            }
        }
    }
}