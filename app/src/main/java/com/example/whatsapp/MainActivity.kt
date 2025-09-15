package com.example.whatsapp

import android.Manifest.permission.READ_CONTACTS
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var contactView: RecyclerView
    private lateinit var userList: ArrayList<ProfileData>
    private lateinit var adapter: ContactsAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_whats_app_home_page)

        contactView = findViewById(R.id.recycleView)
        contactView.layoutManager = LinearLayoutManager(this)
        contactView.setHasFixedSize(true)

        if (checkPermission()) {
            loadContacts()
        } else {
            requestPermission()
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(this, READ_CONTACTS)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(READ_CONTACTS), 101)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Toast.makeText(this, "Permissions are required", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun loadContacts() {
        val cursor: Cursor? =
            contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null)
        cursor?.let {
            userList = ContactsAdaptor.getContact(it, this)
            adapter = ContactsAdaptor(userList)
            contactView.adapter = adapter


adapter.setOnClickItemListener(object : ContactsAdaptor.onItemClickListener{
    override fun onItemClick(position: Int) {
        val contacts = userList[position]
        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply{
            intent.putExtra("profileImage", contacts.profile)
            intent.putExtra("username", contacts.userName)
            intent.putExtra("description", contacts.description)
        }
        startActivity(intent)
    }
})


            cursor.close()
        }
    }}
