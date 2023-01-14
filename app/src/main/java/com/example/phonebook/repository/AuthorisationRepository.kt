package com.example.phonebook.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthorisationRepository {

    private val firebaseAuth: FirebaseAuth = Firebase.auth

    fun isUserLogin(): Boolean {
        return firebaseAuth.currentUser != null
    }

    fun logout() {
        firebaseAuth.signOut()
    }

    fun getEmail(): String {
        return firebaseAuth.currentUser?.email ?: ""
    }

    fun loginUser(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(
            email, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                task.exception?.let { onError() }
            }
        }
    }

    fun registrationUser(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(
            email, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                task.exception?.let { onError() }
            }
        }
    }
}
