package com.example.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class profileAdapter(private val profiles: ArrayList<profileData>): RecyclerView.Adapter<profileAdapter.profileViewHoder>(){
    lateinit var mlistener:onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickItemListener(listener: onItemClickListener){
        mlistener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): profileViewHoder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listofusers,parent, false)
        return profileViewHoder(itemView, mlistener)

    }

    override fun onBindViewHolder(
        holder: profileViewHoder,
        position: Int
    ) {
        var items = profiles[position]
       holder.profile.setBackgroundResource(items.profile)
        holder.username.text = items.userName
        holder.description.text = items.description

    }

    override fun getItemCount(): Int {
      return profiles.size
    }

    inner class profileViewHoder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var profile: ImageView = itemView.findViewById<ImageView>(R.id.profile)
        var username:TextView = itemView.findViewById<TextView>(R.id.username)
        var description:TextView = itemView.findViewById<TextView>(R.id.description)
init {
    itemView.setOnClickListener {
        listener.onItemClick(adapterPosition)
    }
}
















    }



}