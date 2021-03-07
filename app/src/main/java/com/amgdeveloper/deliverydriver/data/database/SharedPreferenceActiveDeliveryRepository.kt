package com.amgdeveloper.deliverydriver.data.database

import android.content.Context
import android.content.SharedPreferences
import com.amgdeveloper.deliverydriver.data.repository.ActiveDeliveryRepository

/**
 * Created by amgdeveloper
 */
class SharedPreferenceActiveDeliveryRepository(private val context: Context) :
    ActiveDeliveryRepository {

    private companion object {
        const val ACTIVE_DELIVERY = "activeDelivery"
        const val SHARED_PREFERENCE = "deliveryDriver"
    }

    override suspend fun setActiveDelivery(id: Long) {
        getSharedPreferencesEditor().putString(ACTIVE_DELIVERY, id.toString()).apply()
    }

    override suspend fun getActiveDelivery(): Long? {
        val value = getSharedPreferences().getString(ACTIVE_DELIVERY, "")
        return if (value != "") value!!.toLong() else null
    }

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)
    }

    private fun getSharedPreferencesEditor(): SharedPreferences.Editor {
        return context.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE).edit()
    }
}