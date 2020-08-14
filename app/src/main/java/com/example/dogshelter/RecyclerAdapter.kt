package com.example.dogshelter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private var names : List<String>, private var locations : List<String>, private var images : List<Int>) :
RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val itemTitle : TextView=itemView.findViewById(R.id.ivTitle)
        val itemDetail : TextView=itemView.findViewById(R.id.ivDescription)
        val itemPicture : ImageView=itemView.findViewById(R.id.ivImage)
        init{
            itemView.setOnClickListener { v: View ->
                var position: Int = adapterPosition
                val intent:Intent=Intent(v.context,DogWatchActivity::class.java)
                var bundle: Bundle = Bundle()
                bundle.putString("dwName", names[position])
                bundle.putString("dwLocation", locations[position])
                intent.putExtra("dImage",images[position])
                intent.putExtras(bundle)
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text=names[position]
        holder.itemDetail.text=locations[position]
        holder.itemPicture.setImageResource(images[position])
    }

}