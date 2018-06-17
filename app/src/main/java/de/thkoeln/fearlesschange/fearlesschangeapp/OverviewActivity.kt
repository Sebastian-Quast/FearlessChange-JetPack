package de.thkoeln.fearlesschange.fearlesschangeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.thkoeln.fearlesschange.fearlesschangeapp.ui.overview.OverviewFragment

class OverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, OverviewFragment.newInstance())
                    .commitNow()
        }
    }

}
