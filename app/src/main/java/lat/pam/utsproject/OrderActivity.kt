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
import com.google.android.material.textfield.TextInputLayout

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        // Terima data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "Unknown Food"
        val foodDescription = intent.getStringExtra("FOOD_DESCRIPTION") ?: "No description available."

        // Mengatur data ke tampilan
        val etFoodName = findViewById<TextView>(R.id.etFoodName)
        etFoodName.text = foodName

        val etServings = findViewById<EditText>(R.id.etServings)
        val etName = findViewById<EditText>(R.id.etName)
        val etNotes = findViewById<EditText>(R.id.etNotes)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            // Validasi setiap input
            if (etServings.text.isNullOrEmpty()) {
                showError("Number of Servings is required")
            } else if (etName.text.isNullOrEmpty()) {
                showError("Ordering Name is required")
            } else if (etNotes.text.isNullOrEmpty()) {
                showError("Additional Notes is required")
            } else {
                // Pindah ke ConfirmationActivity jika semua field sudah terisi
                val confirmationIntent = Intent(this, ConfirmationActivity::class.java)
                confirmationIntent.putExtra("FOOD_NAME", foodName)
                confirmationIntent.putExtra("FOOD_DESCRIPTION", foodDescription)
                confirmationIntent.putExtra("SERVINGS", etServings.text.toString())
                confirmationIntent.putExtra("NAME", etName.text.toString())
                confirmationIntent.putExtra("NOTES", etNotes.text.toString())
                startActivity(confirmationIntent)
            }
        }

        // Menangani inset jendela agar layout lebih responsif
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Fungsi untuk menampilkan pesan kesalahan
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
