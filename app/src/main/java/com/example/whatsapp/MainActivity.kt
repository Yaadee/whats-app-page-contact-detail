package com.example.whatsapp
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var userList: ArrayList<profileData>
    lateinit var profileImage: Array<Int>
    lateinit var username: Array<String>
    lateinit var description: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_whats_app_home_page)



profileImage = arrayOf(
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator,
    R.drawable.avator

)
username = arrayOf("Bob", "Joe", "Doe", "Jane","John", "Joe", "Doe", "Jane")
   description = arrayOf(
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",
       "Hey there I am using WhatSApp",)

        newRecyclerView = findViewById(R.id.recycleView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        userList = arrayListOf<profileData>()
        getUserData()

    }

    private fun getUserData() {
      for(i in profileImage.indices){
          val userprofile = profileData(profileImage[i], username[i], description[i])
          Log.d(TAG, " ${userprofile} ")
          userList.add(userprofile)
      }

        var adaptor = profileAdapter(userList)
        newRecyclerView.adapter = adaptor
        adaptor.setOnClickItemListener(object : profileAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "you clicked on position${position}", Toast.LENGTH_SHORT).show()
            }

        })

        }




}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppTheme {

    }
}