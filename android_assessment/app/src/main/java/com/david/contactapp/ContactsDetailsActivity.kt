package com.david.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.david.contactapp.databinding.ActivityContactsDetailsBinding

class ContactsDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            firstName1.text = intent.getStringExtra("firstName")
            lastName1.text = intent.getStringExtra("lastName")
            emailAddress1.text = intent.getStringExtra("emailAddress")
            phoneNumber1.text = intent.getStringExtra("phoneName")
        }
    }
}