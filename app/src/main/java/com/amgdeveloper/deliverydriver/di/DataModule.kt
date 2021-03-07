package com.amgdeveloper.deliverydriver.di

import android.content.Context
import com.amgdeveloper.deliverydriver.data.repository.ActiveDeliveryRepository
import com.amgdeveloper.deliverydriver.data.repository.DeliveryRepository
import com.amgdeveloper.deliverydriver.data.source.RemoteDeliveryDataSource
import com.amgdeveloper.deliverydriver.data.database.SharedPreferenceActiveDeliveryRepository
import dagger.Module
import dagger.Provides

/**
 * Created by amgdeveloper
 */
@Module
class DataModule {

    @Provides
    fun deliveryRepositoryProvider(
        remoteDeliveryDataSource: RemoteDeliveryDataSource
    ): DeliveryRepository =
        DeliveryRepository(remoteDeliveryDataSource)

    //TODO: move this to app module
    @Provides
    fun activeDeliveryRepositoryProvider(context: Context): ActiveDeliveryRepository =
        SharedPreferenceActiveDeliveryRepository(context)
}