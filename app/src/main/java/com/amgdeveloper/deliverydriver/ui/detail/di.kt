package com.amgdeveloper.deliverydriver.ui.detail

import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.usecases.GetDeliveryById
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by amgdeveloper
 */
@Module
class DeliveryDetailFragmentModule(private val deliveryId: Long) {

    @Provides
    fun deliveryListViewModelProvider(
        getDeliveryById: GetDeliveryById,
        coroutineDispatcher: CoroutineDispatcher
    ): DeliveryDetailViewModel =
        DeliveryDetailViewModel(getDeliveryById, coroutineDispatcher, deliveryId)

    @Provides
    fun getDeliverByIdProvider(deliveryRepository: DeliveryRepository): GetDeliveryById =
        GetDeliveryById(deliveryRepository)

}

@Subcomponent(modules = [DeliveryDetailFragmentModule::class])
interface DeliveryDetailFragmentComponent {

    val deliveryDetailViewModel: DeliveryDetailViewModel
}