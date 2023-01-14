package com.example.phonebook.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.repository.AuthorisationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorisationViewModel : ViewModel() {

    private val authorisationRepository = AuthorisationRepository()

    fun logInUser(email: String, password: String, onSuccess: () -> Unit, onError: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            authorisationRepository.loginUser(email, password, onSuccess, onError)
        }
    }

    fun registrationUser(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            authorisationRepository.registrationUser(email, password, onSuccess, onError)
        }
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            authorisationRepository.logout()
        }
    }
}