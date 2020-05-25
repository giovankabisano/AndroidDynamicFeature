package com.giovankabisano.dynamicfeatures

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
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
                    "Ivysaur",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke002
                ),
                PokemonModel(
                    "Venusaur",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke003
                ),
                PokemonModel(
                    "Charmander",
                    PokemonModel.PokemonType.FIRE,
                    100,
                    R.drawable.poke004
                ),
                PokemonModel(
                    "Charmeleon",
                    PokemonModel.PokemonType.FIRE,
                    100,
                    R.drawable.poke005
                ),
                PokemonModel(
                    "Charizard",
                    PokemonModel.PokemonType.FIRE,
                    100,
                    R.drawable.poke006
                ),
                PokemonModel(
                    "Squirtle",
                    PokemonModel.PokemonType.WATER,
                    100,
                    R.drawable.poke007
                ),
                PokemonModel(
                    "Wartortle",
                    PokemonModel.PokemonType.WATER,
                    100,
                    R.drawable.poke008
                ),
                PokemonModel(
                    "Blastoise",
                    PokemonModel.PokemonType.WATER,
                    100,
                    R.drawable.poke009
                ),
                PokemonModel(
                    "Caterpie",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke010
                ),
                PokemonModel(
                    "Metapod",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke011
                ),
                PokemonModel(
                    "Butterfree",
                    PokemonModel.PokemonType.LEAF,
                    100,
                    R.drawable.poke012
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

    fun onIncompleteShipmentClicked(pokemonModel: PokemonModel) {
        findNavController().navigate(R.id.customMonitorFragment)
    }

}