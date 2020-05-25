package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val incompleteShipmentAdapter: PokemonListAdapter
            by lazy { PokemonListAdapter(::onIncompleteShipmentClicked, requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        recycler.also {
            it.adapter = incompleteShipmentAdapter
            it.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        }

        incompleteShipmentAdapter.submitDataSet(listOf(",", ""))
//        mapOf(
//            Pair(R.id.haha, R.id.customMonitorFragment)
//        ).forEach { (viewId, destinationId) ->
//            view.findViewById<Button>(viewId).setOnClickListener {
//                navController.navigate(destinationId)
//            }
//        }

    }

    fun onIncompleteShipmentClicked() {

    }

}