package com.amgdeveloper.deliverydriver.framework.service

import android.content.Context
import android.content.Intent
import android.os.HandlerThread
import com.amgdeveloper.deliverydriver.data.source.BatteryDataSource
import com.amgdeveloper.deliverydriver.data.source.LocationDataSource
import com.amgdeveloper.deliverydriver.domain.Location
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import kotlinx.coroutines.*
import java.lang.Runnable
import java.util.concurrent.*

/**
 * Created by amgdeveloper
 */
class TrackingController(
    private val context: Context,
    private val getActiveDelivery: GetActiveDelivery,
    private val batteryDataSource: BatteryDataSource,
    private val locationDataSource: LocationDataSource,
) {

    private lateinit var getInfoHandler: android.os.Handler
    private lateinit var getInfoHandlerThread: HandlerThread
    private val intervalScanInSec: Long = 1
    private lateinit var lastAvailableLocation : Location

    suspend fun startTracking() {
        withContext(Dispatchers.IO) {
            if (getActiveDelivery.invoke() != null) {
                getInfoHandlerThread = HandlerThread("trackingThread")
                getInfoHandlerThread.start()
                getInfoHandler = android.os.Handler(getInfoHandlerThread.looper)
                startTrackingService()
            }
        }
    }

    private fun getTrackRunnable(): Runnable =
        Runnable {
            getBatteryInfo()
        }

    fun track() {
        val scheduledThreadPoolExecutor = ScheduledThreadPoolExecutor(20)
        scheduledThreadPoolExecutor.scheduleAtFixedRate(
            getTrackRunnable(),
            0,
            intervalScanInSec,
            TimeUnit.SECONDS
        )
            requestLocation()
    }

    private fun requestLocation(){
        MainScope().launch{
            lastAvailableLocation = getLocationInfo()
        }
    }

    private fun getBatteryInfo(): Int {
        return batteryDataSource.getBatteryLevel()
    }

    private suspend fun getLocationInfo():Location{
        return locationDataSource.getCurrentLocation()
    }

    private fun startTrackingService() {
        val intent = Intent(context, TrackingService::class.java)
        intent.action = TrackingService.ACTION_TRACK
        context.startForegroundService(intent)
    }
}