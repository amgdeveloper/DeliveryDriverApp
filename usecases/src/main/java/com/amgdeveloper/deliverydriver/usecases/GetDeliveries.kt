package com.amgdeveloper.deliverydriver.usecases

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class GetDeliveries(private val repository: DeliveryRepository) {

    suspend fun invoke(): List<Delivery> {
        return repository.getDeliveries()
    }
}