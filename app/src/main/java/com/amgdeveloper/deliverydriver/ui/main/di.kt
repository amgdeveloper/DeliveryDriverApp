package com.amgdeveloper.deliverydriver.ui.main

import com.amgdeveloper.deliverydriver.data.PermissionChecker
import com.amgdeveloper.deliverydriver.data.repository.DeliveryRepository
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
    fun deliveryListViewModelProvider(
        getDeliveries: GetDeliveries, permissionChecker: PermissionChecker,
        coroutineDispatcher: CoroutineDispatcher
    ): DeliveryListViewModel =
        DeliveryListViewModel(getDeliveries, permissionChecker, coroutineDispatcher)

    @Provides
    fun getDeliveriesProvider(deliveryRepository: DeliveryRepository): GetDeliveries =
        GetDeliveries(deliveryRepository)

}

@Subcomponent(modules = [DeliveryListFragmentModule::class])
interface DeliveryListFragmentComponent {

    val deliveryListViewModel: DeliveryListViewModel
}