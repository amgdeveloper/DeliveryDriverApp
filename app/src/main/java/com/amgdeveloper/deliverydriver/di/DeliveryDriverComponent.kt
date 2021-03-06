package com.amgdeveloper.deliverydriver.di

import android.app.Application
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListFragmentComponent
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by amgdeveloper
 */

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ServerModule::class])
interface DeliveryDriverComponent {

    fun plus(module: DeliveryListFragmentModule): DeliveryListFragmentComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): DeliveryDriverComponent
    }
}