package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheesecake", "Cheesecake kejunya enak banget", R.drawable.cheesecake),
            Food("Cireng","cireng kenyal dan enak" ,R.drawable.cireng),
            Food("donut","manis dan buat mood naik",R.drawable.donut),
            Food("Kopi hitam","Kopi hitam buat tahan ngantuk",R.drawable.kopi_hitam),
            Food("Mie goreng","Makanan dikala akhir bulan",R.drawable.mie_goreng),
            Food("Nasi Goreng","Makan enak porsi besar",R.drawable.nasigoreng),
            Food("Sparkling Tea","Minuman buat tenang",R.drawable.sparkling_tea)
        )

        // Mengatur adapter dengan listener
        val adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("FOOD_NAME", food.name)
                putExtra("FOOD_DESCRIPTION", food.description)
                putExtra("FOOD_IMAGE", food.imageResourceId)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
