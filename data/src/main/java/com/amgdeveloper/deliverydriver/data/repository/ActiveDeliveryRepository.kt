package com.amgdeveloper.deliverydriver.data.repository

/**
 * Created by amgdeveloper
 */
interface ActiveDeliveryRepository {

    suspend fun setActiveDelivery(id: Long)

    suspend fun getActiveDelivery(): Long?
}