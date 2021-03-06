package com.amgdeveloper.deliverydriver.di

import android.app.Application
import android.content.Context
import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.data.server.DeliveryServer
import com.amgdeveloper.deliverydriver.data.server.DeliveryServerDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

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

    @Provides
    @Singleton
    fun appContextProvider(app: Application): Context {
        return app
    }
}