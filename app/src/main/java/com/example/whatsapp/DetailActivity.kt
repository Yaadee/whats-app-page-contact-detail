package com.example.whatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.whatsapp.databinding.ActivityMainBinding



class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


    binding.backIcon.setOnClickListener {
    binding = findViewById(R.layout.fragment_whats_app_home_page)


    }
        val profileImage = intent.getIntExtra("profileImage",R.drawable.avator )
        val username = intent.getStringExtra("username")
        val description = intent.getStringExtra("description")


        binding.username.text = username
        binding.avator.setImageResource(profileImage)
        binding.description.text = description



    binding.callContent.backgroundAndToast("Calling...", "header")
    binding.videocallcontent.backgroundAndToast("Video calling", "header")
    binding.idOnwhatApp.backgroundAndToast("description", "not")
    binding.searchContent.backgroundAndToast("Searching", "header")
    binding.medialinksdocsblock.backgroundAndToast("Media, links and docs", "not")
    binding.notification.backgroundAndToast("Notification", "not")
    binding.mediaContent.backgroundAndToast("Media Content",  "not")
    binding.encryptionBlock.backgroundAndToast("Encryption...", "not")
    binding.disappearingBody.backgroundAndToast("Disappearing messages", "not")
    binding.chatLockBody.backgroundAndToast("Chat Lock", "not")
    binding.advancedSecurityBody.backgroundAndToast("Advanced Security", "not")


    binding.commonGroupContainer.backgroundAndToast("Add to group", "not")


    binding.otherphoneId.backgroundAndToast("Other Phone", "not")
    binding.otherCallId.backgroundAndToast("Calling ...", "not")
    binding.otherChatid.backgroundAndToast("Chatting...", "not")
    binding.otherVideoCallId.backgroundAndToast("Video call", "not")


    binding.favouriteBlock.backgroundAndToast("Added to favorite", "not")
    binding.addToListBlock.backgroundAndToast("Add to list", "not")
    binding.blockUserBlock.backgroundAndToast("Block User", "not")


    binding.reportUserBlock.backgroundAndToast("Report User", "not" )

}

}





@SuppressLint("ClickableViewAccessibility")
fun View.backgroundAndToast(msg: CharSequence, type:String ) {
    val context = this.context

    this.setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if(type == "header"){
                    v.setBackgroundResource(R.drawable.colored_layout_bg)
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                }
                else {
                    v.setBackgroundResource(R.color.whiteGray)
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                }
                true
            }

            MotionEvent.ACTION_UP -> {
                if(type == "header"){

                    v.setBackgroundResource(R.drawable.layout_bg)
                } else {
                    v.setBackgroundResource(R.color.white)

                }
                false
            }


            else -> false


        }


    }


}



