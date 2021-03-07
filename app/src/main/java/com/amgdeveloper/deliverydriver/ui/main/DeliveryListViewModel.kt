package com.amgdeveloper.deliverydriver.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.amgdeveloper.deliverydriver.common.Event
import com.amgdeveloper.deliverydriver.common.ScopedViewModel
import com.amgdeveloper.deliverydriver.data.PermissionChecker
import com.amgdeveloper.deliverydriver.domain.Delivery
import com.amgdeveloper.deliverydriver.usecases.GetDeliveries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch


/**
 * Created by amgdeveloper
 */
class DeliveryListViewModel(
    private val getDeliveries: GetDeliveries,
    private val permissionChecker: PermissionChecker,
    coroutineDispatcher: CoroutineDispatcher
) :
    ScopedViewModel(coroutineDispatcher) {

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val deliveries: List<Delivery>) : UiModel()
        object RequestLocationPermission : UiModel()
    }

    private val _navigation = MutableLiveData<Event<Delivery>>()
    val navigation: LiveData<Event<Delivery>> = _navigation

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) checkPermission()
            return _model
        }


    private fun checkPermission() {
        _model.value = UiModel.RequestLocationPermission
        launch {
            requestPermission()
        }
    }

    private suspend fun requestPermission(){
        permissionChecker.check(PermissionChecker.Permission.FINE_LOCATION)
    }

    fun onFineLocationPermissionRequested() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getDeliveries.invoke())
        }
    }

    fun onDeliveryClicked(recipe: Delivery) {
        _navigation.value = Event(recipe)
    }
}