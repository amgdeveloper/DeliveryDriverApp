package com.amgdeveloper.deliverydriver.di

import com.amgdeveloper.deliverydriver.data.repository.ActiveDeliveryRepository
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import dagger.Module
import dagger.Provides

/**
 * Created by amgdeveloper
 */
@Module
class UseCases {

    @Provides
    fun getActiveDeliveryProvider(activeDeliveryRepository: ActiveDeliveryRepository) =
        GetActiveDelivery(activeDeliveryRepository)
}