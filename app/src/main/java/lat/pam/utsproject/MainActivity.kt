package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<TextView>(R.id.tvRegister)
        registerButton.setOnClickListener{
            val intent = Intent (this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.btnLogin)
        loginButton.setOnClickListener{
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            when {
                username.isEmpty() -> {
                    // Pesan error jika username kosong
                    showError("Username is required")
                }
                password.isEmpty() -> {
                    // Pesan error jika password kosong
                    showError("Password is required")
                }
                username == "ghanihd" && password == "1234" -> {
                    // Login berhasil, lanjut ke halaman berikutnya
                    val intent = Intent(this, ListFoodActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    // Pesan error jika username atau password salah
                    showError("Invalid username or password")
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi untuk menampilkan pesan error
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
