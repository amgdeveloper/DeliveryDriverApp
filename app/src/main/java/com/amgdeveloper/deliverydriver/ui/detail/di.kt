package com.amgdeveloper.deliverydriver.ui.detail

import com.amgdeveloper.deliverydriver.data.ActiveDeliveryRepository
import com.amgdeveloper.deliverydriver.data.DeliveryRepository
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import com.amgdeveloper.deliverydriver.usecases.GetDeliveryById
import com.amgdeveloper.deliverydriver.usecases.SetActiveDelivery
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
        setActiveDelivery: SetActiveDelivery,
        getActiveDelivery: GetActiveDelivery,
        coroutineDispatcher: CoroutineDispatcher
    ): DeliveryDetailViewModel =
        DeliveryDetailViewModel(
            getDeliveryById, setActiveDelivery,
            getActiveDelivery, coroutineDispatcher, deliveryId
        )

    @Provides
    fun getDeliverByIdProvider(deliveryRepository: DeliveryRepository): GetDeliveryById =
        GetDeliveryById(deliveryRepository)

    @Provides
    fun setActiveDeliveryProvider(activeDeliveryRepository: ActiveDeliveryRepository) =
        SetActiveDelivery(activeDeliveryRepository)
}

@Subcomponent(modules = [DeliveryDetailFragmentModule::class])
interface DeliveryDetailFragmentComponent {

    val deliveryDetailViewModel: DeliveryDetailViewModel
}