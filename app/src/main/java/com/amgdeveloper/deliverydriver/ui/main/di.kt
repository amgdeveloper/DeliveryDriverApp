package com.amgdeveloper.deliverydriver.ui.main

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by amgdeveloper
 */
@Module
class DeliveryListFragmentModule {

    @Provides
    fun deliveryListViewModelProvider(coroutineDispatcher: CoroutineDispatcher): DeliveryListViewModel =
        DeliveryListViewModel(coroutineDispatcher)
}

@Subcomponent(modules = [DeliveryListFragmentModule::class])
interface DeliveryListFragmentComponent {

    val deliveryListViewModel: DeliveryListViewModel
}