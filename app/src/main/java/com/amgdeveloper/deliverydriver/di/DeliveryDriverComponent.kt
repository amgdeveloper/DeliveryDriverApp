package com.amgdeveloper.deliverydriver.di

import android.app.Application
import com.amgdeveloper.deliverydriver.common.DeliveryDriverApp
import com.amgdeveloper.deliverydriver.ui.detail.DeliveryDetailFragmentComponent
import com.amgdeveloper.deliverydriver.ui.detail.DeliveryDetailFragmentModule
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListFragmentComponent
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by amgdeveloper
 */

@Singleton
@Component(modules = [AppModule::class, DataModule::class, ServerModule::class, UseCases::class])
interface DeliveryDriverComponent {

    fun plus(module: DeliveryListFragmentModule): DeliveryListFragmentComponent

    fun plus(module: DeliveryDetailFragmentModule): DeliveryDetailFragmentComponent

    fun inject(app: DeliveryDriverApp)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): DeliveryDriverComponent
    }
}