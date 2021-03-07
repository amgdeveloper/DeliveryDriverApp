package com.amgdeveloper.deliverydriver.di

import android.content.Context
import com.amgdeveloper.deliverydriver.data.ActiveDeliveryRepository
import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.data.RemoteDeliveryDataSource
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