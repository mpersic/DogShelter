package com.example.dogshelter

import android.content.Intent
import android.os.Bundle
import android.os.TokenWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity: AppCompatActivity() {
    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        handler= DatabaseHelper(this)

        userLoginButton.setOnClickListener{
            if(handler.userPresent(loginEmail.text.toString(),loginPassword.text.toString())) {
                Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }
            else
            Toast.makeText(this,"Invalid username or password!",Toast.LENGTH_SHORT).show()
        }
    }

}