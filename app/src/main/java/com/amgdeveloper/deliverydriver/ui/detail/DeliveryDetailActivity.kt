package com.amgdeveloper.deliverydriver.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.amgdeveloper.deliverydriver.R
import com.amgdeveloper.deliverydriver.common.fragmentExists


/**
 * Created by amgdeveloper
 */
class DeliveryDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DELIVERY_ID = "delivery_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_detail)

        val recipeId = intent.getLongExtra(EXTRA_DELIVERY_ID, 555)
        if (recipeId != -1L) {
            displayRecipeDetails(recipeId)
        }
    }

    private fun displayRecipeDetails(recipeId: Long) {
        if (!supportFragmentManager.fragmentExists(DeliveryDetailFragment.TAG)) {
            val fragment = DeliveryDetailFragment()
            val bundle = Bundle()
            bundle.putLong(EXTRA_DELIVERY_ID, recipeId)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.deliveryDetailsActivityFl, fragment, DeliveryDetailFragment.TAG)
                .commit()
        }
    }
}