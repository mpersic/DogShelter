package com.example.dogshelter

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class RegistrationActivity:AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_registration)
        handler=DatabaseHelper(this)
        saveButtonRegistration.setOnClickListener{
            if(passwordsAreEqual(passwordRegistration.text.toString(),confirmPasswordRegistration.text.toString())){
                if(handler.userPresent(emailRegistration.text.toString(),passwordRegistration.text.toString())){
                    Toast.makeText(this,"Email already used!",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Successfully registered!",Toast.LENGTH_SHORT).show()
                    handler.insertUserData(nameRegistration.text.toString(), emailRegistration.text.toString(), passwordRegistration.text.toString())
                    val intent=Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                }
            }
            else
            Toast.makeText(this,"Passwords dont match!",Toast.LENGTH_SHORT).show()
        }
    }

}
fun passwordsAreEqual(password:String,RepeatedPassword:String):Boolean{
    return password==RepeatedPassword
}