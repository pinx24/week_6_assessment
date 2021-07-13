package com.david.contactapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val first: String,
    val last: String,
    val email: String,
    val phone: Long


)
