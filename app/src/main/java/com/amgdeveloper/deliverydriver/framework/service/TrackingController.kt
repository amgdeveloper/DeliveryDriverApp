package com.amgdeveloper.deliverydriver.framework.service

import android.content.Context
import android.content.Intent
import android.os.HandlerThread
import com.amgdeveloper.deliverydriver.data.BatteryDataSource
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.*

/**
 * Created by amgdeveloper
 */
class TrackingController(
    private val context: Context,
    private val getActiveDelivery: GetActiveDelivery,
    private val batteryDataSource: BatteryDataSource,
) {

    private lateinit var getInfoHandler: android.os.Handler
    private lateinit var getInfoHandlerThread: HandlerThread
    private val intervalScanInSec: Long = 1

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
            getTrackingInfo()
        }

    fun track() {
        val scheduledThreadPoolExecutor = ScheduledThreadPoolExecutor(20)
        scheduledThreadPoolExecutor.scheduleAtFixedRate(
            getTrackRunnable(),
            0,
            intervalScanInSec,
            TimeUnit.SECONDS
        )
    }

    private fun getTrackingInfo(): Int {
        return batteryDataSource.getBatteryLevel()
    }

    private fun startTrackingService() {
        val intent = Intent(context, TrackingService::class.java)
        intent.action = TrackingService.ACTION_TRACK
        context.startForegroundService(intent)
    }
}