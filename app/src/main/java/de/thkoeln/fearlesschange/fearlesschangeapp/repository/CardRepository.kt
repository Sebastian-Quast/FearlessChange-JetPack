package de.thkoeln.fearlesschange.fearlesschangeapp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.daos.CardDao
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.database.CardDatabase
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card


class CardRepository(application: Application) {

    private var mCardDao: CardDao
    private var mAllCards: LiveData<List<Card>>

    init {
        val db = CardDatabase.getInstance(application)
        mCardDao = db.cardDao()
        mAllCards = mCardDao.getCards()
    }

    fun getAllCards(): LiveData<List<Card>> {
        return mAllCards
    }

    //fun insert(cards: List<Card>) {
    //    InsertAsyncTask(mCardDao).execute(cards)
    //}
//
    //private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: CardDao) : AsyncTask<List<Card>, Void, Void>() {
//
    //    override fun doInBackground(vararg params: List<Card>): Void? {
    //        mAsyncTaskDao.insertCards(params[0])
    //        return null
    //    }
    //}


}