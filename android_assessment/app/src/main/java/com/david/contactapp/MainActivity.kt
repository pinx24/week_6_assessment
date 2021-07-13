package com.david.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.david.contactapp.adapters.ContactAdapter
import com.david.contactapp.databinding.ActivityMainBinding
import com.david.contactapp.models.Contact
import com.david.contactapp.models.ContactDatabase
import com.david.contactapp.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: ContactDatabase
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(
            applicationContext, ContactDatabase::class.java,
            "contacts_database"
        ).allowMainThreadQueries().build()

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getContacts(database)

        viewModel.contactsLiveData.observe(this, { contacts ->
            contactAdapter = ContactAdapter(contacts) {
                val intent = Intent(this@MainActivity, ContactsDetailsActivity::class.java)
                intent.run {
                    putExtra("id", it.id.toString())
                    putExtra("firstName", it.first)
                    putExtra("lastName", it.last)
                    putExtra("emailAddress", it.email)
                    putExtra("phoneNumber", it.phone)
                }
                startActivity(intent)
            }

            binding.contactRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = contactAdapter
            }

        })

        binding.saveButton.setOnClickListener {
            val first = binding.firstName.text.toString()
            val last = binding.lastName.text.toString()
            val email = binding.emailAddress.text.toString()
            val phone = binding.phoneNumber.text.toString()

            saveContact(first, last, email, phone.toLong())
        }
    }

    private fun saveContact(
        firstName: String,
        lastName: String,
        emailAddress: String,
        phoneNumber: Long
    ) {
        val contact = Contact(id = 0, firstName, lastName, emailAddress, phoneNumber)
        viewModel.addContacts(database, contact)
    }
}