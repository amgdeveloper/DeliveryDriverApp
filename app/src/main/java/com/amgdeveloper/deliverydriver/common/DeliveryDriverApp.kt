package com.amgdeveloper.deliverydriver.common

import android.app.Application
import com.amgdeveloper.deliverydriver.di.DaggerDeliveryDriverComponent
import com.amgdeveloper.deliverydriver.di.DeliveryDriverComponent
import com.amgdeveloper.deliverydriver.framework.service.TrackingController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by amgdeveloper
 */

open class DeliveryDriverApp : Application() {

    lateinit var component: DeliveryDriverComponent
    @Inject
    lateinit var trackingController: TrackingController

    override fun onCreate() {
        super.onCreate()

        component = initDeliveryDriverComponent()
        component.inject(this)
        MainScope().launch{
            trackingController.startTracking()
        }
    }

    open fun initDeliveryDriverComponent() = DaggerDeliveryDriverComponent.factory().create(this)
}