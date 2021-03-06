package com.amgdeveloper.deliverydriver.di

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.data.server.CustomServerDataSource
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


    @Provides
    fun remoteDeliveryDataSourceProvider(): RemoteDeliveryDataSource = CustomServerDataSource()

}