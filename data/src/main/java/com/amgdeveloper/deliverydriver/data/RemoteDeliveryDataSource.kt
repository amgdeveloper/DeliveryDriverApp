package com.amgdeveloper.deliverydriver.data

import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
interface RemoteDeliveryDataSource {

    suspend fun getDeliveries(): List<Delivery>

    suspend fun getDelivery(id: Long): Delivery
}