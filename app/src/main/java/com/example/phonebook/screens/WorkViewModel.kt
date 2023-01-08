package com.example.phonebook.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.model.Contact
import com.example.phonebook.repository.FirebaseRepository
import kotlinx.coroutines.launch

@Suppress("CAST_NEVER_SUCCEEDS")
class WorkViewModel : ViewModel() {

    private val repositoryFirebase = FirebaseRepository()
    private val listContact = MutableLiveData<List<Contact>>()

    fun saveContact(name: String, number: String) {
        viewModelScope.launch {
            listContact.postValue(repositoryFirebase.addContact(name, number) as List<Contact>)
        }
    }

//    fun getContact(onChange: (list: List<Contact>) -> Unit) {
//        viewModelScope.launch {
//            listContact.value = repositoryFirebase.getContact(onChange)
//        }
//    }
}