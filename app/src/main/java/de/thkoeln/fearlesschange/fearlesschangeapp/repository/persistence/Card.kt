package de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "card_table")
data class Card constructor(
        @PrimaryKey val id: Long,
        val title: String,
        val picturePath: String,
        val problem: String,
        val buts: String,
        val solution: String
        //val keywords: List<String> = listOf())
)