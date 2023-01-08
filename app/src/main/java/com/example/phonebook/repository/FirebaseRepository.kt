package com.example.phonebook.repository

import android.util.Log
import com.example.phonebook.model.Contact
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class FirebaseRepository {

    private val database = Firebase.database.reference

    fun addContact(name: String, number: String) {
        database.child("contact").child(Firebase.auth.currentUser?.uid ?: "")
            .child(UUID.randomUUID().toString()).setValue(
                Contact(
                    Firebase.auth.currentUser?.uid ?: "",
                    name, number
                )
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    //
                } else {
                    task.exception?.let { //
                        //
                    }
                }
            }
    }

    fun getContact(onChange: (list: List<Contact>) -> Unit) {
        database.child("contact").child(
            Firebase.auth.currentUser?.uid ?: ""
        )
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val list = arrayListOf<Contact>()
                    dataSnapshot.children.forEach { dataSnapshot ->
                        (dataSnapshot.getValue(Contact::class.java))?.let { contact ->
                            list.add(contact)
                        }
                    }
                    onChange(list)
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
    }
}