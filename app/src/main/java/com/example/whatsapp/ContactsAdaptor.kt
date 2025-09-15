package com.example.whatsapp

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.runtime.currentRecomposeScope
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections.addAll
import kotlin.collections.ArrayList

@SuppressLint("Range")

class ContactsAdaptor(private val profiles: ArrayList<ProfileData>): RecyclerView.Adapter<ContactsAdaptor.contactViewHolder>(){
    companion object Contacts {
        @SuppressLint("Recycle")
        fun getContact(cursor: Cursor, context: Context): ArrayList<ProfileData>{
            val contactlist =  ArrayList<ProfileData>()
            if (cursor.moveToFirst()){
                do {
                    val contactName = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                    val contactId = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                    val photoUrl = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.PHOTO_URI))

                    val phone = context.contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        "${ContactsContract.CommonDataKinds.Phone.CONTACT_ID} = ?",
                        arrayOf(contactId),
                        null


                    )
                    phone?.let{phoneCursor->
                        if (phoneCursor.moveToFirst()) {
                            do {
                                val phoneNumber =
                                    phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                                val defaultProfile = R.drawable.avator
                                val contacts = ProfileData(defaultProfile, contactName, phoneNumber)

                                contactlist.add(contacts)

                            } while (phoneCursor.moveToNext())
                        }

                    }

                } while (cursor.moveToNext())

                cursor.close()
            }



            return contactlist

        }

    }
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
    ): contactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listofusers, parent, false)
        return contactViewHolder(itemView, mlistener)
    }

    override fun onBindViewHolder(
        holder: contactViewHolder,
        position: Int
    ) {
        var contacts = profiles[position]
        holder.profile.setImageResource(contacts.profile)
        holder.username.text = contacts.userName
        holder.description.text = contacts.description
    }

    override fun getItemCount(): Int {
        return profiles.size
    }



    inner class contactViewHolder (itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
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