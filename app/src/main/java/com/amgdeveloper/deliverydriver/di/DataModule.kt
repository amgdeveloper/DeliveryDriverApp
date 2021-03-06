package com.amgdeveloper.deliverydriver.di

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by amgdeveloper
 */
@Module
class DataModule {
    @Provides
    fun deliveryRepositoryProvider(remoteDeliveryDataSource: RemoteDeliveryDataSource): DeliveryRepository =
        DeliveryRepository(remoteDeliveryDataSource)
}