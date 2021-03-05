package com.amgdeveloper.deliverydriver.common

import androidx.fragment.app.FragmentManager


fun FragmentManager.fragmentExists(TAG: String): Boolean {
    return findFragmentByTag(TAG) != null
}
