package com.example.whatsapp
import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.ResourcesCompat
import com.example.whatsapp.databinding.ActivityMainBinding
import com.example.whatsapp.ui.theme.WhatsAppTheme

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.callContent.setOnClickListener {
            it.setBackgroundResource(R.drawable.colored_layout_bg)
            Toast.makeText(getApplicationContext(), "Calling...", Toast.LENGTH_SHORT).show();
        }
        binding.videocallcontent.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Video Calling", Toast.LENGTH_SHORT).show()
           it.setBackgroundResource(R.drawable.colored_layout_bg)



        }

binding.searchContent.setOnClickListener {
    it.setBackgroundResource(R.drawable.colored_layout_bg)
    Toast.makeText(getApplicationContext(), "Searching...", Toast.LENGTH_SHORT).show()
}
        val mediaDocLink = findViewById<RelativeLayout>(R.id.notificationMedia)
        mediaDocLink.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Media, links, and docs", Toast.LENGTH_SHORT).show()

        }

        val notification = findViewById<RelativeLayout>(R.id.notificationMedia)
        notification.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show()

        }

        val media = findViewById<RelativeLayout>(R.id.mediaContent)
        media.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Media", Toast.LENGTH_SHORT).show()
        }
        val encryption = findViewById<LinearLayout>(R.id.encryptionContent)
        encryption.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Encryption Clicked", Toast.LENGTH_SHORT).show()
        }
        val disappearing = findViewById<RelativeLayout>(R.id.disappearingBody)
        disappearing.setOnClickListener {
            Toast.makeText(getApplicationContext(), "Disappearing, messages", Toast.LENGTH_SHORT).show()

        }
        val chatLock = findViewById<RelativeLayout>(R.id.chatLockBody)
        chatLock.setOnClickListener {
            Toast.makeText(getApplicationContext(),"Chat Lock clicked" , Toast.LENGTH_SHORT).show() }
        val advancedSecurity = findViewById<RelativeLayout>(R.id.advancedSecurityBody)
        advancedSecurity.setOnClickListener { Toast.makeText(getApplicationContext(), "Advanced Security",
            Toast.LENGTH_SHORT).show() }



        val createGroup = findViewById<RelativeLayout>(R.id.commonGroupContainer)
        createGroup.setOnClickListener { Toast.makeText(getApplicationContext(), "Create Group with...",

            Toast.LENGTH_SHORT).show() }


val otherPhone = findViewById<TextView>(R.id.otherphoneId)
        otherPhone.setOnClickListener { Toast.makeText(applicationContext, "Other Phone", Toast.LENGTH_SHORT).show() }
        val otherCall = findViewById<ImageView>(R.id.otherCallId)
        otherCall.setOnClickListener { Toast.makeText(applicationContext, "Calling...", Toast.LENGTH_SHORT).show() }

        val chat = findViewById<ImageView>(R.id.otherChatid)
        chat.setOnClickListener { Toast.makeText(applicationContext, "Chatting...", Toast.LENGTH_SHORT).show() }

        val otherVideoCall = findViewById<ImageView>(R.id.otherVideoCallId)
        otherVideoCall.setOnClickListener { Toast.makeText(applicationContext, "Video calling...",
            Toast.LENGTH_SHORT).show() }


        val addToFavourite = findViewById<RelativeLayout>(R.id.favouriteBlock)
        addToFavourite.setOnClickListener { Toast.makeText(applicationContext, "Added to favourite ", Toast.LENGTH_SHORT).show()}

        val addToList = findViewById<RelativeLayout>(R.id.addToListBlock)
        addToList.setOnClickListener { Toast.makeText(applicationContext, "Choose List", Toast.LENGTH_SHORT).show() }
        val blockUser = findViewById<RelativeLayout>(R.id.blockUserBlock)
        blockUser.setOnClickListener { Toast.makeText(applicationContext, "Block User ${findViewById<TextView>(R.id.username)} ?",
            Toast.LENGTH_SHORT).show()
        }
        val reportUser = findViewById<RelativeLayout>(R.id.reportUserBlock)
        reportUser.setOnClickListener { Toast.makeText(applicationContext, "Report to WhatsApp",
            Toast.LENGTH_SHORT).show() }









    }






}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppTheme {

    }
}