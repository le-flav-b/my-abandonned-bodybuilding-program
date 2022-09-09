package fr.leflavb.mybodybuildingprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.leflavb.mybodybuildingprogram.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load database
        val data = Database()

        // update data
        data.updateData {
            // inject the fragment into the box
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // inject home fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}