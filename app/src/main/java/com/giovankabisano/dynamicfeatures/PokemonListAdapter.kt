package com.giovankabisano.dynamicfeatures

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_pokemon_list.view.*

class PokemonListAdapter(
    private val clickJobCard: () -> Unit,
    private val context: Context
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private var dataSet = mutableListOf<String>()

    fun submitDataSet(incompleteShipmentsDataSet: List<String>) {
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
        val context: Context
    ) : RecyclerView.ViewHolder(view) {

        fun bind(waitingForAssignmentJob: String) {
            itemView.card.setCardBackgroundColor(context.resources.getColor(R.color.water_type_dark))
        }
    }
}