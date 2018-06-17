package de.thkoeln.fearlesschange.fearlesschangeapp.repository.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card

@Dao
interface CardDao {

    @Insert
    fun insertCards(card: List<Card>)

    @Query("Select * From card_table")
    fun getCards(): LiveData<List<Card>>
}