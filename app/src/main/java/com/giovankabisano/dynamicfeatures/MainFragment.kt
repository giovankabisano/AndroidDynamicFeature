package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.giovankabisano.dynamicfeatures.model.PokemonModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val incompleteShipmentAdapter: PokemonListAdapter
            by lazy { PokemonListAdapter(::onIncompleteShipmentClicked, requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        recycler.also {
            it.adapter = incompleteShipmentAdapter
            it.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        incompleteShipmentAdapter.submitDataSet(
            listOf(
                PokemonModel(
                    "Bulbasaur",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke001
                ),
                PokemonModel(
                    "Bulbasaur",
                    PokemonModel.PokemonType.WATER,
                    100,
                    R.drawable.poke001
                ),
                PokemonModel(
                    "Bulbasaur",
                    PokemonModel.PokemonType.FIRE,
                    100,
                    R.drawable.poke001
                )
            )
        )
//        mapOf(
//            Pair(R.id.haha, R.id.customMonitorFragment)
//        ).forEach { (viewId, destinationId) ->
//            view.findViewById<Button>(viewId).setOnCli8ckListener {
//                navController.navigate(destinationId)
//            }
//        }

    }

    fun onIncompleteShipmentClicked() {

    }

}