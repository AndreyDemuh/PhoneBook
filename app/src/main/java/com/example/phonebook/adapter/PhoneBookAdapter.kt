package com.example.phonebook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.phonebook.databinding.ItemPhoneBookBinding
import com.example.phonebook.model.Contact

class PhoneBookAdapter : ListAdapter<Contact, PhoneBookViewHolder>(ContactsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneBookViewHolder {
        return PhoneBookViewHolder(
            ItemPhoneBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhoneBookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}