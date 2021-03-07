package com.amgdeveloper.deliverydriver.data.server

import com.amgdeveloper.deliverydriver.data.source.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.data.toDomainDelivery
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class DeliveryServerDataSource(private val deliveryServer: DeliveryServer) :
    RemoteDeliveryDataSource {

    override suspend fun getDeliveries(): List<Delivery> =
        deliveryServer.service.getDeliveries().map { it.toDomainDelivery() }

    override suspend fun getDelivery(id: Long): Delivery =
        deliveryServer.service.getDelivery(id).toDomainDelivery()

}