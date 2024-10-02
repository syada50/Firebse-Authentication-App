package com.example.authentication_firebase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModels : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    // Sign up function
    fun signUp(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result.value = "SignUp Success"
                } else {
                    result.value = task.exception?.message ?: "SignUp Failed"
                }
            }
        return result
    }

    // Sign in function
    fun signIn(email: String, password: String): LiveData<String> {
        val result = MutableLiveData<String>()
        auth.signInWithEmailAndPassword(email, password)  // Change made here
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    result.value = "Signin Success"
                } else {
                    result.value = task.exception?.message ?: "Signin Failed"
                }
            }
        return result
    }

    // Sign out function
    fun signout() {
        auth.signOut()
    }
}
