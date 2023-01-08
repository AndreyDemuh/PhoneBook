package com.example.phonebook.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.databinding.ItemPhoneBookBinding
import com.example.phonebook.model.Contact

class PhoneBookViewHolder(private val binding: ItemPhoneBookBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(contact: Contact) {
        binding.run {
            name.text = contact.name
            number.text = contact.number
        }
    }
}