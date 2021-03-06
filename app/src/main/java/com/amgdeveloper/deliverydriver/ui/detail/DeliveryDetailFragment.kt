package com.amgdeveloper.deliverydriver.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amgdeveloper.deliverydriver.common.app
import com.amgdeveloper.deliverydriver.common.getViewModel
import com.amgdeveloper.deliverydriver.databinding.FragmentDeliveryDetailBinding


/**
 * Created by amgdeveloper on 22/11/2020
 */
class DeliveryDetailFragment : Fragment() {

    private lateinit var component: DeliveryDetailFragmentComponent
    private lateinit var binding: FragmentDeliveryDetailBinding
    private val viewModel: DeliveryDetailViewModel by lazy { getViewModel { component.deliveryDetailViewModel } }

    companion object {
        val TAG: String = DeliveryDetailFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val recipeId = it.getLong(DeliveryDetailActivity.EXTRA_DELIVERY_ID)
            component = requireContext().app.component.plus(DeliveryDetailFragmentModule(recipeId))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeliveryDetailBinding.inflate(inflater, container, false)

        context?.let {
            viewModel.model.observe(viewLifecycleOwner, {
                updateUi(it)
            })
        }
        return binding.root
    }

    private fun updateUi(model: DeliveryDetailViewModel.UIModel) = with(binding) {
        val delivery = model.delivery
        allInfoTv.text = delivery.toString()
    }
}