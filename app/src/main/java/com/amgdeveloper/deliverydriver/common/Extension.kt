package com.amgdeveloper.deliverydriver.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get


fun FragmentManager.fragmentExists(TAG: String): Boolean {
    return findFragmentByTag(TAG) != null
}

inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProvider(this, vmFactory).get()
}

val Context.app: DeliveryDriverApp
    get() = applicationContext as DeliveryDriverApp
