package com.amgdeveloper.deliverydriver.data.repository

import com.amgdeveloper.deliverydriver.data.source.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class DeliveryRepository(private val remoteDeliveryDataSource: RemoteDeliveryDataSource) {

    suspend fun getDeliveries(): List<Delivery> {
        return remoteDeliveryDataSource.getDeliveries()
    }

    suspend fun getDeliveryById(id: Long): Delivery {
        return remoteDeliveryDataSource.getDelivery(id)
    }
}