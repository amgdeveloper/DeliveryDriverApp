package com.amgdeveloper.deliverydriver.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amgdeveloper.deliverydriver.common.Event
import com.amgdeveloper.deliverydriver.common.ScopedViewModel
import com.amgdeveloper.deliverydriver.domain.Delivery
import com.amgdeveloper.deliverydriver.usecases.GetDeliveries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Created by amgdeveloper
 */
class DeliveryListViewModel(
    private val getDeliveries: GetDeliveries,
    coroutineDispatcher: CoroutineDispatcher
) :
    ScopedViewModel(coroutineDispatcher) {

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
        launch {
            _model.value = UiModel.Loading

            withContext(Dispatchers.IO){

               val result = UiModel.Content(getDeliveries.invoke())

                withContext(Dispatchers.Main){
                    _model.value =result
                }
            }
        }
    }

    fun onDeliveryClicked(recipe: Delivery) {
        _navigation.value = Event(recipe)
    }
}