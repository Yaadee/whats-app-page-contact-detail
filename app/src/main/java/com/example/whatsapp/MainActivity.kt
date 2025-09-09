package com.example.whatsapp
import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.media.metrics.Event
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.res.ResourcesCompat
import com.example.whatsapp.databinding.ActivityMainBinding
import com.example.whatsapp.ui.theme.WhatsAppTheme
import kotlin.time.TimeSource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.callContent.backgroundAndToast("Calling...", "header")
        binding.videocallcontent.backgroundAndToast("Video calling", "header")
        binding.searchContent.backgroundAndToast("Searching", "header")
        binding.medialinksdocsblock.backgroundAndToast("Media, links and docs", "not")
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
                        true
                     }
                     else {
                         v.setBackgroundResource(R.color.whiteGray)
                         Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                         true
                     }
                      true
                 }

                 MotionEvent.ACTION_UP -> {
                     if(type == "header"){

                         v.setBackgroundResource(R.drawable.layout_bg)
                         true
                     } else {
                         v.setBackgroundResource(R.color.white)

                     }
                     true
                 }


                 else -> false


             }


     }


 }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhatsAppTheme {

    }
}