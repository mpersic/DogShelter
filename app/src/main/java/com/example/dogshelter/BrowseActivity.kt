package com.example.dogshelter

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.dog_add_activity.*
import kotlinx.android.synthetic.main.recycler_activity.*

class BrowseActivity:AppCompatActivity() {

    private var namesList= mutableListOf<String>()
    private var locationsList= mutableListOf<String>()
    private var imagesList= mutableListOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {

            var intent: Intent =intent
            super.onCreate(savedInstanceState)
            setContentView(R.layout.recycler_activity)

            var name:String?=null
            var location:String?=null
            val bundle:Bundle?= intent.extras
            var image:Int?=null


            if(bundle!=null){
            //image=bundle.getInt("dImage")
            name=bundle!!.getString("dName")
            location=bundle!!.getString("dLocation")
            }

            //postToList()

            recyclerview.layoutManager=LinearLayoutManager(this)
            recyclerview.adapter=RecyclerAdapter(namesList,locationsList,imagesList)

             addToList("Max","Osijek",R.mipmap.beagle)
             addToList("Rex","Zagreb",R.mipmap.pug)
             addToList("Timmy","Slatina",R.mipmap.labrador)
             if(!name.isNullOrEmpty()||!location.isNullOrEmpty()) {
                 //if (image != null)
                     addToList(name.toString(), location.toString(),R.mipmap.beagle)
             }

    }

    private fun addToList(name:String,location:String,image:Int){
        namesList.add(name)
        locationsList.add(location)
        imagesList.add(image)
    }
    private fun postToList(){
        for(i in 1..25){
            addToList("Name $i","location $i",R.mipmap.ic_launcher)
        }
    }
}