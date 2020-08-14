package com.example.dogshelter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        dogAdderButton.setOnClickListener{
            val intent = Intent(applicationContext,DogAddingActivity::class.java)
            startActivity(intent)
        }
        dogBrowserButton.setOnClickListener{
            val intent = Intent(applicationContext,BrowseActivity::class.java)
            startActivity(intent)
        }
    }
}