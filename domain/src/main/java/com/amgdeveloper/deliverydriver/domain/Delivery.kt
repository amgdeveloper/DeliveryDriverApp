package com.amgdeveloper.deliverydriver.domain

/**
 * Created by amgdeveloper on 05/03/2021
 */

data class Delivery(
    val id: Long,
    val address: String,
    val latitude: Float,
    val longitude: Float,
    val customerName: String,
    val requiresSignature: Boolean,
    val specialInstructions: String
)