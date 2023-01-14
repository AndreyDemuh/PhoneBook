package com.example.phonebook.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phonebook.model.Contact

class ContactsDiffUtil : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return false
    }
}