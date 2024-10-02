package com.example.authentication_firebase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.authentication_firebase.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var viewModel: AuthViewModels
    private lateinit var binding: ActivityHomeBinding // Use ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AuthViewModels::class.java)

        // Correctly set the OnClickListener for logoutBtn
        binding.logoutBtn.setOnClickListener {
            viewModel.signout()
            startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
            finish() // Optionally call finish() to close the HomeActivity
        }
    }
}
