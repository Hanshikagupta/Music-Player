package com.example.musicapp.adapter

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Data
import com.example.musicapp.R
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val dataList: List<Data>)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(context).inflate(R.layout.items,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData =dataList[position]
        val mediaPlayer =MediaPlayer.create(context, currentData.preview.toUri())
        holder.title.text =currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.image)

        holder.playmusic.setOnClickListener {
            mediaPlayer.start()
        }
        holder.pausemusic.setOnClickListener {
            mediaPlayer.pause()
        }
    }

    class MyViewHolder(itemView:  View) :RecyclerView.ViewHolder(itemView){
       val image:ImageView
       val title: TextView
       val playmusic :ImageView
       val pausemusic:ImageView

       init {
           image=itemView.findViewById(R.id.musicimage)
           title=itemView.findViewById(R.id.musictitle)
           playmusic=itemView.findViewById(R.id.play)
           pausemusic=itemView.findViewById(R.id.pause)
       }
    }

}