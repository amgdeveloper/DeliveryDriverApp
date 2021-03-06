package com.amgdeveloper.deliverydriver.ui.main

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.usecases.GetDeliveries
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
    fun deliveryListViewModelProvider(getDeliveries: GetDeliveries, coroutineDispatcher: CoroutineDispatcher): DeliveryListViewModel =
        DeliveryListViewModel(getDeliveries, coroutineDispatcher)

    @Provides
    fun getDeliveriesProvider(deliveryRepository: DeliveryRepository): GetDeliveries =
        GetDeliveries(deliveryRepository)

}

@Subcomponent(modules = [DeliveryListFragmentModule::class])
interface DeliveryListFragmentComponent {

    val deliveryListViewModel: DeliveryListViewModel
}