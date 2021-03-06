package com.amgdeveloper.deliverydriver.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amgdeveloper.deliverydriver.common.Event
import com.amgdeveloper.deliverydriver.common.ScopedViewModel
import com.amgdeveloper.deliverydriver.domain.Delivery
import kotlinx.coroutines.Dispatchers


/**
 * Created by amgdeveloper on 05/03/2021
 */
class DeliveryListViewModel() :
    ScopedViewModel(Dispatchers.Main) {  //TODO: inject the UI Dispatcher

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val deliveries: List<Delivery>) : UiModel()
    }

    private val _navigation = MutableLiveData<Event<Delivery>>()
    val navigation: LiveData<Event<Delivery>> = _navigation

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }


    private fun refresh() {
        _model.value = UiModel.Content(loadDemoDeliveries())
    }


    private fun loadDemoDeliveries(): List<Delivery> {
        return listOf(
            Delivery(1, "adddress 1", 1.1F, 2.2F, "Customer name 1", false, ""),
            Delivery(2, "adddress 2", 1.1F, 2.2F, "Customer name 2", false, ""),
            Delivery(3, "adddress 3", 1.1F, 2.2F, "Customer name 3", false, "")
        )
    }

    fun onDeliveryClicked(recipe: Delivery) {
        _navigation.value = Event(recipe)
    }
}