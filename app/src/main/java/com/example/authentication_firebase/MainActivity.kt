package com.example.authentication_firebase


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This is your splash screen layout

        // Delay for 3 seconds before moving to the RegistrationActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, RegistrationActivity::class.java))
            finish() // Finish MainActivity to prevent users from coming back to it
        }, 3000) // Adjust the delay as needed
    }
}
