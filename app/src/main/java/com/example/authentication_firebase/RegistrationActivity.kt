package com.example.authentication_firebase


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authentication_firebase.databinding.ActivityRegistrationBinding


class RegistrationActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModels
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(AuthViewModels::class.java)

        // Set click listener for the register button
        binding.registerBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            val conPass = binding.confirmPasswordEt.text.toString()

            // Validate input fields
            when {
                email.isEmpty() || password.isEmpty() || conPass.isEmpty() -> {
                    showToast("Please fill all fields")
                }
                password != conPass -> {
                    showToast("Passwords do not match")
                }
                else -> {
                    // Attempt to sign up
                    viewModel.signUp(email, conPass).observe(this, { result ->
                        showToast(result)

                        // Navigate to HomeActivity if sign up was successful
                        if (result == "SignUp Success") {
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish() // Optional: Close RegistrationActivity
                        }
                    })
                }
            }
        }

        // Set click listener for the already have an account text
        binding.AlreadyHaveAnAccountTxt.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    // Helper function to show Toast messages
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}