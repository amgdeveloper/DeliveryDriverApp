package com.amgdeveloper.deliverydriver.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amgdeveloper.deliverydriver.common.ScopedViewModel
import com.amgdeveloper.deliverydriver.domain.Delivery
import com.amgdeveloper.deliverydriver.usecases.GetActiveDelivery
import com.amgdeveloper.deliverydriver.usecases.GetDeliveryById
import com.amgdeveloper.deliverydriver.usecases.SetActiveDelivery
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch


/**
 * Created by amgdeveloper
 */
class DeliveryDetailViewModel(
    private val getDeliveryById: GetDeliveryById,
    private val setActiveDelivery: SetActiveDelivery,
    private val getActiveDelivery: GetActiveDelivery,
    override val uiDispatcher: CoroutineDispatcher,
    private val recipeId: Long
) : ScopedViewModel(uiDispatcher) {

    data class UIModel(val delivery : Delivery, val active:Boolean)
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
            val activeDeliverId = getActiveDelivery.invoke()
            val active: Boolean = (activeDeliverId != null && delivery.id == activeDeliverId)
            _model.value = UIModel(delivery, active)
        }
    }

    fun onActivateClicked() {
        launch {
            setActiveDelivery.invoke(recipeId)
            if (_model.value != null) {
                _model.value = UIModel(_model.value!!.delivery, !_model.value!!.active)
            }
        }
    }
}