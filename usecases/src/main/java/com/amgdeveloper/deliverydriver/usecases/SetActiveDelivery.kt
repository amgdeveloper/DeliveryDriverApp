package com.amgdeveloper.deliverydriver.usecases

import com.amgdeveloper.deliverydriver.data.ActiveDeliveryRepository

/**
 * Created by amgdeveloper
 */
class SetActiveDelivery(private val activeDeliveryRepository: ActiveDeliveryRepository) {

    suspend fun invoke(id: Long) {
        activeDeliveryRepository.setActiveDelivery(id)
    }
}