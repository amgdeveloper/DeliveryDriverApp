package com.amgdeveloper.deliverydriver.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amgdeveloper.deliverydriver.common.ScopedViewModel
import com.amgdeveloper.deliverydriver.domain.Delivery
import com.amgdeveloper.deliverydriver.usecases.GetDeliveryById
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch


/**
 * Created by amgdeveloper
 */
class DeliveryDetailViewModel(
    private val getDeliveryById: GetDeliveryById,

        override val uiDispatcher: CoroutineDispatcher,
        private val recipeId: Long) : ScopedViewModel(uiDispatcher) {

    data class UIModel(val delivery : Delivery)
    private lateinit var delivery : Delivery

    private val _model = MutableLiveData<UIModel>()
    val model: LiveData<UIModel>
        get() {
            if (_model.value == null) getDelivery(recipeId)
            return _model
        }

    private fun getDelivery(id: Long) {
        launch {
            delivery = getDeliveryById.invoke(id)
            _model.value = UIModel(delivery)
        }
    }
}