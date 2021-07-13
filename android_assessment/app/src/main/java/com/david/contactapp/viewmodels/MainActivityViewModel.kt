package com.david.contactapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.david.contactapp.models.Contact
import com.david.contactapp.models.ContactDatabase

class MainActivityViewModel: ViewModel() {

    val contactsLiveData = MutableLiveData<List<Contact>>()

    fun getContacts(database: ContactDatabase) {
        contactsLiveData.postValue(database.contactDao().getAllContact())
    }

    fun addContacts(database: ContactDatabase, contact: Contact) {
        database.contactDao().addContact(contact)
        getContacts(database)
    }
}