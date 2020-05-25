package com.giovankabisano.dynamicfeatures

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giovankabisano.dynamicfeatures.model.PokemonModel
import kotlinx.android.synthetic.main.view_holder_pokemon_list.view.*

class PokemonListAdapter(
    private val onClick: () -> Unit,
    private val context: Context
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private var dataSet = mutableListOf<PokemonModel>()

    fun submitDataSet(incompleteShipmentsDataSet: List<PokemonModel>) {
        dataSet.clear()
        dataSet.addAll(incompleteShipmentsDataSet)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.view_holder_pokemon_list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return ViewHolder(
            inflater.inflate(R.layout.view_holder_pokemon_list, parent, false),
            context
        )
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    inner class ViewHolder(
        view: View,
        private val context: Context
    ) : RecyclerView.ViewHolder(view) {

        fun bind(pokemon: PokemonModel) {
            itemView.card.setCardBackgroundColor(
                when (pokemon.type) {
                    PokemonModel.PokemonType.LEAF -> {
                        context.resources.getColor(R.color.leaf_type)
                    }
                    PokemonModel.PokemonType.WATER -> {
                        context.resources.getColor(R.color.water_type)
                    }
                    PokemonModel.PokemonType.FIRE -> {
                        context.resources.getColor(R.color.fire_type)
                    }
                }
            )
            itemView.name.text = pokemon.name
            itemView.type.text = pokemon.type.toString()
            itemView.level.text = pokemon.level.toString()
            itemView.image.setImageDrawable(context.getDrawable(pokemon.image))
        }
    }
}