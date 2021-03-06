package com.amgdeveloper.deliverydriver.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.amgdeveloper.deliverydriver.common.app
import com.amgdeveloper.deliverydriver.common.getViewModel
import com.amgdeveloper.deliverydriver.databinding.FragmentRecipeListBinding
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListViewModel.UiModel.Content
import com.amgdeveloper.deliverydriver.ui.main.DeliveryListViewModel.UiModel.Loading

/**
 * Created by amgdeveloper
 */
class DeliveryListFragment : Fragment() {

    private lateinit var component: DeliveryListFragmentComponent
    private val viewModel: DeliveryListViewModel by lazy { getViewModel { component.deliveryListViewModel } }
    private lateinit var adapter: DeliveryListAdapter
    private lateinit var progressDialog: ProgressBar

    companion object {
        val TAG: String = DeliveryListFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRecipeListBinding.inflate(layoutInflater, container, false)

        component = requireContext().app.component.plus(DeliveryListFragmentModule())

        val recyclerView = binding.recyclerView
        progressDialog = binding.progressbar

        adapter = DeliveryListAdapter(emptyList(), viewModel::onDeliveryClicked)
        recyclerView.adapter = adapter
        viewModel.model.observe(viewLifecycleOwner, Observer(this::updateUi))

        viewModel.navigation.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {

            }
        })
        return binding.root
    }

    private fun updateUi(model: DeliveryListViewModel.UiModel) {
        progressDialog.visibility = if (model == Loading) View.VISIBLE else View.GONE
        when (model) {
            is Content -> {
                adapter.deliveries = model.deliveries
                adapter.notifyDataSetChanged()
            }
        }
    }
}

