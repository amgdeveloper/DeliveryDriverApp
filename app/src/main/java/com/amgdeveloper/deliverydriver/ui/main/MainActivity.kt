package com.amgdeveloper.deliverydriver.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amgdeveloper.deliverydriver.R
import com.amgdeveloper.deliverydriver.common.fragmentExists
import com.amgdeveloper.deliverydriver.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root

        setContentView(rootView)
        displayDeliveryListFragment()
    }

    private fun displayDeliveryListFragment() {
        if (!supportFragmentManager.fragmentExists(DeliveryListFragment.TAG)) {
            val fragment = DeliveryListFragment()
            supportFragmentManager.beginTransaction().replace(
                R.id.mainActivityFl, fragment, DeliveryListFragment.TAG
            ).commit()
        }
    }
}