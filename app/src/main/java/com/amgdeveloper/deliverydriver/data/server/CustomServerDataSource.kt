package com.amgdeveloper.deliverydriver.data.server

import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class CustomServerDataSource : RemoteDeliveryDataSource {

    override suspend fun getDeliveries(): List<Delivery> {
        Thread.sleep(1000)
        return listOf(
            Delivery(1, "adddress 1", 1.1F, 2.2F, "Customer name 1", false, ""),
            Delivery(2, "adddress 2", 1.1F, 2.2F, "Customer name 2", false, ""),
            Delivery(3, "adddress 3", 1.1F, 2.2F, "Customer name 3", false, "")
        )
    }
}