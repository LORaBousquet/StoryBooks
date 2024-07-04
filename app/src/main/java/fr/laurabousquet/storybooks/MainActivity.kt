package fr.laurabousquet.storybooks

import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.laurabousquet.storybooks.fragments.AddBookFragment
import fr.laurabousquet.storybooks.fragments.CollectionFragment
import fr.laurabousquet.storybooks.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment(this), R.string.home_page_title)

        // importer la bottomnavigationview
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home_page -> {
                    loadFragment(HomeFragment(context = this), R.string.home_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.collection_page -> {
                    loadFragment(CollectionFragment(this), R.string.bibliotheque_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.add_book_page -> {
                   loadFragment(AddBookFragment(this), R.string.add_book_page_title)
                   return@setOnNavigationItemSelectedListener true
                }

                else -> false
            }
        }



    }
    private fun loadFragment(fragment: Fragment, string:Int){

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


    }
    // injecter le fragment dans notre boite (fragment_container)
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
        // actualiser le titre de la page
        findViewById<TextView>(R.id.page_title).text = resources.getString(string)

}
}