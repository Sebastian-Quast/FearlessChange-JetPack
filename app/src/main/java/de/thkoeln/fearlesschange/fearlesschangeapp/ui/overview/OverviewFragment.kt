package de.thkoeln.fearlesschange.fearlesschangeapp.ui.overview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import de.thkoeln.fearlesschange.fearlesschangeapp.R
import de.thkoeln.fearlesschange.fearlesschangeapp.adapters.OverviewGridAdapter
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card
import kotlinx.android.synthetic.main.overview_fragment.*


class OverviewFragment : Fragment() {

    companion object {
        fun newInstance() = OverviewFragment()
    }

    private lateinit var viewModel: OverviewViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.overview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(context, 2)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)

        viewModel.getAllCards().observe(this, Observer<List<Card>> { cards ->
            // Update the cached copy of the cards in the adapter.
            recyclerView.adapter = OverviewGridAdapter(cards!!) { Int -> doWhenClicked(Int) }
        })
    }

    private fun doWhenClicked(int: Int) {
        Toast.makeText(context, "Clicked $int ", Toast.LENGTH_SHORT).show()
    }

}
