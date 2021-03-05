package com.amgdeveloper.deliverydriver.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amgdeveloper.deliverydriver.databinding.FragmentRecipeListBinding

/**
 * Created by amgdeveloper on 18/11/2020
 */
class DeliveryListFragment : Fragment() {

    companion object {
        val TAG: String = DeliveryListFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRecipeListBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}