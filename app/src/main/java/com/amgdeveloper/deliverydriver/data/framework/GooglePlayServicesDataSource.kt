package com.amgdeveloper.deliverydriver.data.framework

import android.annotation.SuppressLint
import android.app.Application
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import com.amgdeveloper.deliverydriver.data.source.LocationDataSource
import com.amgdeveloper.deliverydriver.domain.Location
import com.amgdeveloper.deliverydriver.framework.receiver.LocationReceiver
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume


/**
 * Created by amgdeveloper
 */
class GooglePlayServicesDataSource(val application: Application) : LocationDataSource {

    private val requestInterval: Long = TimeUnit.SECONDS.toMillis(10)
    private val smallestDisplacement: Float = 100F
    private val REQUEST_LOCATION: String = "request_location"
    private val REQUEST_CODE_LOCATION: Int = 99
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private fun getLocationRequest(): LocationRequest {
        val locationRequest = LocationRequest.create()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.smallestDisplacement = smallestDisplacement
        locationRequest.interval = requestInterval
        return locationRequest
    }

    private fun getPendingIntent(): PendingIntent {
        val intent = Intent(application, LocationReceiver::class.java)
        intent.action = REQUEST_LOCATION
        return PendingIntent.getBroadcast(
            application, REQUEST_CODE_LOCATION, intent, PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    override suspend fun getCurrentLocation() :Location{
        initialize()
        val result = getLastLocation()
        requestLocations()
        return result
    }

    fun initialize(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(application)

    }

    @SuppressLint("MissingPermission")
    private suspend fun getLastLocation():Location = suspendCancellableCoroutine {     continuation ->
        fusedLocationClient.lastLocation.addOnCompleteListener() {
        continuation.resume(it.result.toDomainLocation())}
    }

    //TODO: make the proper permission check
    @SuppressLint("MissingPermission")
    private fun requestLocations(){
        val locationRequest: LocationRequest = getLocationRequest()
        val pendingIntent: PendingIntent = getPendingIntent()
        fusedLocationClient.requestLocationUpdates(locationRequest, pendingIntent)
    }
}

private fun android.location.Location.toDomainLocation():Location= Location(latitude,longitude)