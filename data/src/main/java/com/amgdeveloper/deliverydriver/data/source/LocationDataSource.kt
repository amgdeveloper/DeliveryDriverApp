package com.amgdeveloper.deliverydriver.data.source

import com.amgdeveloper.deliverydriver.domain.Location

/**
 * Created by amgdeveloper
 */
interface LocationDataSource {

    suspend fun getCurrentLocation() : Location
}