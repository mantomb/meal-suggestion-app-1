package vcmsa.ci.mealsuggestionapp1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTime: EditText = findViewById(R.id.inputTime)
        val btnSuggest: Button = findViewById(R.id.btnSuggest)
        val btnReset: Button = findViewById(R.id.btnReset)
        val txtSuggestion: TextView = findViewById(R.id.txtSuggestion)

        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            val suggestion = when (timeOfDay) {
                "morning" -> "Breakfast: Eggs"
                "mid-morning" -> "Snack: Fruit"
                "afternoon" -> "Lunch: Sandwich"
                "mid-afternoon" -> "Snack: Cake"
                "dinner" -> "Main Course: Pasta"
                "after dinner" -> "Dessert: Ice Cream"
                else -> null
            }

            if (suggestion != null) {
                txtSuggestion.text = suggestion
            } else {
                Toast.makeText(this, "Invalid input! Please enter a valid time of day.", Toast.LENGTH_SHORT).show()
            }
        }

        btnReset.setOnClickListener {
            inputTime.text.clear()
            txtSuggestion.text = ""
        }
    }
}