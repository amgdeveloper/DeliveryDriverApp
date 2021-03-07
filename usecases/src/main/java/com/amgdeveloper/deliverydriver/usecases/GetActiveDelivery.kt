package com.amgdeveloper.deliverydriver.usecases

import com.amgdeveloper.deliverydriver.data.repository.ActiveDeliveryRepository

/**
 * Created by amgdeveloper
 */
class GetActiveDelivery(private val activeDeliveryRepository: ActiveDeliveryRepository) {

    suspend fun invoke(): Long? {
        return activeDeliveryRepository.getActiveDelivery()
    }
}