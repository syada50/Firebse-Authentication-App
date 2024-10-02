package com.example.authentication_firebase
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authentication_firebase.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModels
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AuthViewModels::class.java)

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Call signIn method instead of signUp
                viewModel.signIn(email, password).observe(this, { result ->
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()

                    if (result == "Signin Success") {
                        startActivity(Intent(this, HomeActivity::class.java))
                        finish() // Close LoginActivity
                    }
                })
            }
        }
    }
}
