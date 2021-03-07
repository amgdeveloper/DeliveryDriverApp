package com.amgdeveloper.deliverydriver.framework.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.amgdeveloper.deliverydriver.framework.receiver.AlarmReceiver
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by amgdeveloper
 */
class TrackingController(
    private val context: Context,
    private val getActiveDelivery: GetActiveDelivery
) {

    suspend fun startTracking() {

        withContext(Dispatchers.IO) {
            if (getActiveDelivery.invoke() != null) {
                startTrackingService()
                setAlarm()
            }
        }
    }

    private fun setAlarm() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        intent.action = "Track"
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        val delay: Long = 10000
        val alarmTimeAtUTC: Long = System.currentTimeMillis() + delay

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.M) {
            alarmManager.setAlarmClock(
                AlarmManager.AlarmClockInfo(alarmTimeAtUTC, pendingIntent),
                pendingIntent
            )
        } else {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                alarmTimeAtUTC,
                pendingIntent
            )
        }
    }

    private fun startTrackingService() {
        val intent = Intent(context, TrackingService::class.java)
        context.startForegroundService(intent)
    }
}