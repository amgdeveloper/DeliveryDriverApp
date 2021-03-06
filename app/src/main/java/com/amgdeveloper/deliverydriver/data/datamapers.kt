package com.amgdeveloper.deliverydriver.data

import com.amgdeveloper.deliverydriver.data.server.Delivery as ServerDelivery
import com.amgdeveloper.deliverydriver.domain.Delivery as DomainDelivery

/**
 * Created by amgdeveloper
 */

fun ServerDelivery.toDomainDelivery(): DomainDelivery =
    DomainDelivery(
        id, address, latitude, longitude, customerName, requiresSignature, specialInstructions
    )

