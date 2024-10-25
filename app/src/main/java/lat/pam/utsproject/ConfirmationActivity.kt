package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "Unknown Food"
        val servings = intent.getStringExtra("SERVINGS") ?: "0"
        val name = intent.getStringExtra("NAME") ?: "Anonymous"
        val notes = intent.getStringExtra("NOTES") ?: "No notes"

        // Tampilkan data di TextView sesuai XML
        findViewById<TextView>(R.id.tvTitle).text = "Order Food"
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.tvOrderingName).text = "Ordering Name: $name"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $notes"

        // Tombol kembali ke menu utama
        val buttonBack = findViewById<Button>(R.id.backtoMenu)
        buttonBack.setOnClickListener {
            startActivity(Intent(this, ListFoodActivity::class.java))
        }

        // Atur padding untuk inset
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
