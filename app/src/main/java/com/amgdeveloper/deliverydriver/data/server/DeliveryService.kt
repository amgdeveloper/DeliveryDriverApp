package com.amgdeveloper.deliverydriver.data.server

import retrofit2.http.GET

/**
 * Created by amgdeveloper
 */
interface DeliveryService  {

    @GET("deliveries")
    suspend fun getDeliveries():List <Delivery>
}