package com.example.dogshelter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.dog_add_activity.*
import java.io.Serializable
import java.util.jar.Manifest


class DogAddingActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dog_add_activity)

        addPictureButton.setOnClickListener {
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                    val permission= arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permission, permissionCode)
                }
                else{
                    pickImageFromGallery()
                }
            }
            else{
                pickImageFromGallery()
            }
        }

        addDogButton.setOnClickListener {
            val image=dogsImage.drawable
            //if(image==R.id.) Toast.makeText(this,"Put your dog's picture!",Toast.LENGTH_SHORT).show()
            var name = dogName.text.toString()
            if(name==null) Toast.makeText(this,"What is your dog's name",Toast.LENGTH_SHORT).show()
            var location = dogLocation.text.toString()
            if(location==null) Toast.makeText(this,"Where is your dog located?",Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this, BrowseActivity::class.java)
                var bundle: Bundle = Bundle()
                bundle.putString("dName", name)
                bundle.putString("dLocation", location)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

        private fun pickImageFromGallery() {
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent, imageCode)
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            when(requestCode){
                permissionCode-> {
                    if((grantResults.isNotEmpty())&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        pickImageFromGallery()
                    }
                    else{
                        Toast.makeText(this,"Permission denied",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if(resultCode==Activity.RESULT_OK&&requestCode== imageCode){
                dogsImage.setImageURI(data?.data)
            }
        }
        companion object{
            private val imageCode=1000
            private val permissionCode=1001
        }
}
