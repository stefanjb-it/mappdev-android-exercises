package at.fh.mappdev.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView

class RatingActivity : AppCompatActivity() {

    private val rating = Rating("android_lesson_01")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
    }

    fun saveRating(v: View) {
        rating.feedback = findViewById<EditText>(R.id.feedback_input).text.toString()
        rating.rating = findViewById<RatingBar>(R.id.rating_bar).rating.toDouble() //binding.ratingBar.rating.toDouble()
        findViewById<TextView>(R.id.lesson).text = rating.lesson
        findViewById<TextView>(R.id.feedback).text = rating.feedback
        findViewById<TextView>(R.id.rating_value).text = rating.rating?.toString() ?: "0"
    }
}
