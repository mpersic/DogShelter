package com.example.dogshelter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dog_watch.*

class DogWatchActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_watch)
        var name:String?=null
        var location:String?=null
        var dogId:Int?=null
        val bundle:Bundle?= intent.extras


        if(bundle!=null){
            dogId=bundle.getInt("dImage")
            name=bundle!!.getString("dwName")
            location=bundle!!.getString("dwLocation")
        }
        if(!name.isNullOrEmpty()||!location.isNullOrEmpty()){
            watchdogName.setText(name)
            watchdogLocation.setText(location)
            if (dogId != null) {
                watchdogImage.setImageResource(dogId)
            }
        }
    }
}