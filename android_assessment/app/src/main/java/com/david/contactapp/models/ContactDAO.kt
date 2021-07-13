package com.david.contactapp.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Query("SELECT * FROM contact")
    fun getAllContact(): List<Contact>

    @Query("SELECT * FROM contact WHERE id = :id")
    fun getContactById(id: Int): Contact

    @Insert
    fun addContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}