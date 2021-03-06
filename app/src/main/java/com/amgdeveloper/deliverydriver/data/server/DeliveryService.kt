package com.amgdeveloper.deliverydriver.data.server

import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by amgdeveloper
 */
interface DeliveryService {

    @GET("deliveries")
    suspend fun getDeliveries(): List<Delivery>

    @GET("delivery/{id}")
    suspend fun getDelivery(@Path("id") id: Long): Delivery
}