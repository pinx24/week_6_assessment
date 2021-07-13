package com.david.contactapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.contactapp.databinding.ContactItemBinding
import com.david.contactapp.models.Contact

class ContactAdapter(private val contacts: List<Contact>, val onClicker: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(private val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
           binding.apply {
                firstName.text = contact.first
               lastName.text = contact.last
               emailAddress.text = contact.email
               phoneNumber.text = contact.phone.toString()
               root.setOnClickListener { onClicker(contact) }
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ContactItemBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}