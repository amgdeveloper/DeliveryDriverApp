package com.amgdeveloper.deliverydriver.usecases

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.domain.Delivery

/**
 * Created by amgdeveloper
 */
class GetDeliveryById(val recipeRepository: DeliveryRepository) {

    suspend fun invoke(id: Long): Delivery {
        return recipeRepository.getDeliveryById(id)
    }
}