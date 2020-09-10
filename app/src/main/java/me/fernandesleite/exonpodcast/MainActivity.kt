package me.fernandesleite.exonpodcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navHostFragment  = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.mainPageFragment, R.id.discoverPageFragment, R.id.downloadedPageFragment), drawerLayout)

        navigationView.setupWithNavController(navController)
        setSupportActionBar(toolbar)
        setupWithNavController(toolbar, navController, appBarConfiguration)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
}