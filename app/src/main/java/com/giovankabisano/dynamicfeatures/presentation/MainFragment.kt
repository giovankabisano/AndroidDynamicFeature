package com.giovankabisano.dynamicfeatures.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.giovankabisano.dynamicfeatures.R
import com.giovankabisano.dynamicfeatures.model.PokemonModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val pokemonListAdapter: PokemonListAdapter
            by lazy {
                PokemonListAdapter(
                    ::onPokemonClicked
                )
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        recycler.also {
            it.adapter = pokemonListAdapter
            it.layoutManager = GridLayoutManager(requireContext(), 2)
        }

        /**
         * Hardcoded data.
         * If you want full list data of Pokemon, you can access that here
         * https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/pokemon.json
         */
        pokemonListAdapter.submitDataSet(
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
    }

    /**
     * @description:
     * Action function after one of the pokemon list get clicked.
     *
     * *******************************************************************************************************
     * **For now, no matter what kind of pokemon that get clicked by the user,                              **
     * **we always showing Bulbasaur Detail, because the purpose of this codelab is to show DynamicFeatures.**
     * *******************************************************************************************************
     *
     * @param: pokemonModel -> We can get the ID of pokemon that getting clicked and request the pokemon detail from backend.
     *
     */
    private fun onPokemonClicked(pokemonModel: PokemonModel) {
        findNavController().navigate(R.id.pokemonDetailFragment)
    }

}