package com.example.fitx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (email == "kumar" && password == "1") {
                // Success -> Navigate to Home Screen
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, GenderSelectActivity::class.java))
                finish()
            } else {
                // Failure
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
