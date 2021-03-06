package com.amgdeveloper.deliverydriver.common

import android.app.Application
import com.amgdeveloper.deliverydriver.di.DaggerDeliveryDriverComponent
import com.amgdeveloper.deliverydriver.di.DeliveryDriverComponent

/**
 * Created by amgdeveloper
 */

open class DeliveryDriverApp : Application() {

    lateinit var component: DeliveryDriverComponent

    override fun onCreate() {
        super.onCreate()

        component = initDeliveryDriverComponent()
    }

    open fun initDeliveryDriverComponent() = DaggerDeliveryDriverComponent.factory().create(this)
}