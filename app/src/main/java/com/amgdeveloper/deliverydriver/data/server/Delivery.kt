package com.amgdeveloper.deliverydriver.data.server

import com.google.gson.annotations.SerializedName

/**
 * Created by amgdeveloper on 05/03/2021
 */

data class Delivery(
    val id: Long,
    val address: String,
    val latitude: Float,
    val longitude: Float,
    @SerializedName("customer_name")
    val customerName: String,
    val requiresSignature: Boolean?,
    @SerializedName("special_instructions")
    val specialInstructions: String?
)