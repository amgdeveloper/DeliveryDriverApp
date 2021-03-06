package com.amgdeveloper.deliverydriver.di

import com.amgdeveloper.deliverydriver.data.server.DeliveryServer
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by amgdeveloper
 */
@Module
class ServerModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String {
        return  "https://my-json-server.typicode.com/amgdeveloper/DeliveryDriverFakeAPI/"
    }

    @Provides
    fun customDeliveryServerProvider(@Named("baseUrl") baseUrl: String):DeliveryServer =
        DeliveryServer(baseUrl)
}
