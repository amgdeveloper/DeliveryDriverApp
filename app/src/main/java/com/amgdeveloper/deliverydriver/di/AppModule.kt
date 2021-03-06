package com.amgdeveloper.deliverydriver.di

import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.data.server.DeliveryServer
import com.amgdeveloper.deliverydriver.data.server.DeliveryServerDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Created by amgdeveloper
 */

@Module
class AppModule {

    @Provides
    fun coroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    fun remoteDeliveryDataSourceProvider(deliveryServer: DeliveryServer): RemoteDeliveryDataSource =
        DeliveryServerDataSource(deliveryServer)
}