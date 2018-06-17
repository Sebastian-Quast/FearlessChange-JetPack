package de.thkoeln.fearlesschange.fearlesschangeapp.ui.overview

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.CardRepository
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card

class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private var mRepository: CardRepository = CardRepository(application)
    private var mAllCards: LiveData<List<Card>>

    init {
        mAllCards = mRepository.getAllCards()
    }

    fun getAllCards(): LiveData<List<Card>> {
        return mAllCards
    }

}
