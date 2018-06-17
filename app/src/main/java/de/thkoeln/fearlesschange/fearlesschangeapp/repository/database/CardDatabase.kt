package de.thkoeln.fearlesschange.fearlesschangeapp.repository.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.daos.CardDao
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.Card
import de.thkoeln.fearlesschange.fearlesschangeapp.repository.persistence.CardData

@Database(entities = arrayOf(Card::class), version = 1)
abstract class CardDatabase : RoomDatabase() {

    abstract fun cardDao(): CardDao

    companion object {
        @Volatile
        private var INSTANCE: CardDatabase? = null

        fun getInstance(context: Context): CardDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }


        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        CardDatabase::class.java, "card_database")
                        .addCallback(object : Callback() {
                            //Called when the database is created for the first time
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).cardDao().insertCards(CardData.CARDS)
                                }
                            }
                        })
                        .build()
    }
}