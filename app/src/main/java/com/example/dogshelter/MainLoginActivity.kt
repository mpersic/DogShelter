package com.example.dogshelter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class MainLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activityLoginButton.setOnClickListener{
            val intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
        }
        activityRegisterButton.setOnClickListener{
            val intent = Intent(applicationContext,RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}