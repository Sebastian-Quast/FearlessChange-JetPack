package de.thkoeln.fearlesschange.fearlesschangeapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import de.thkoeln.fearlesschange.fearlesschangeapp.R
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card
import de.thkoeln.fearlesschange.fearlesschangeapp.utils.inflate
import de.thkoeln.fearlesschange.fearlesschangeapp.utils.loadUrl
import kotlinx.android.synthetic.main.card_grid_item.view.*

class OverviewGridAdapter(private val items: List<Card>,
                          val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<OverviewGridAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
            CardViewHolder(parent.inflate(R.layout.card_grid_item))

    override fun getItemCount(): Int =
            items.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) =
            holder.bind(items[position])


    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(card: Card) = with(itemView) {

            card_image.loadUrl(card.picturePath)
            card_grid_item_title.text = card.title
            card_grid_item_problem.text = card.problem

            card_grid_item_card_view.setOnClickListener { clickListener(adapterPosition) }
        }

    }

}

