package lat.pam.utsproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val usernameInput = findViewById<EditText>(R.id.regUsername)
        val passwordInput = findViewById<EditText>(R.id.regPassword)
        val confirmPasswordInput = findViewById<EditText>(R.id.etConfirmPassword)
        val registerButton = findViewById<Button>(R.id.RegisterBtn)

        registerButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            when {
                username.isEmpty() -> showError("Username is required")
                password.isEmpty() -> showError("Password is required")
                confirmPassword.isEmpty() -> showError("Please confirm your password")
                password != confirmPassword -> showError("Passwords do not match")
                else -> {
                    // Proses registrasi berhasil
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                    finish() // Kembali ke MainActivity
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
