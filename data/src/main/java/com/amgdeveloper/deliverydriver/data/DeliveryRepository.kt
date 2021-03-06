package com.amgdeveloper.deliverydriver.data

import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class DeliveryRepository(private val remoteDeliveryDataSource: RemoteDeliveryDataSource) {

    suspend fun getDeliveries(): List<Delivery> {
        return remoteDeliveryDataSource.getDeliveries()
    }
}