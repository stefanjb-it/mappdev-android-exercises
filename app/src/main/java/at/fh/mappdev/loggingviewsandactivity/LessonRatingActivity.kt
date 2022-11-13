package at.fh.mappdev.loggingviewsandactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import org.w3c.dom.Text

class LessonRatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_rating)
        val id =  intent.getStringExtra(LessonListActivity.EXTRA_LESSON_ID)
        if (id == null) {
            return;
        }
        LessonRepository.lessonById(id,
            success = {
                    findViewById<TextView>(R.id.lesson_rating_header).text = it.name
                      },
            error = {
                    findViewById<TextView>(R.id.lesson_rating_header).text = "UNKNOWN"
                    }
        )
        findViewById<Button>(R.id.rate_lesson).setOnClickListener {
            LessonRepository.rateLesson(id,LessonRating(findViewById<RatingBar>(R.id.lesson_rating_bar).rating.toDouble(),findViewById<TextView>(R.id.lesson_feedback).text.toString()),
            success = {
            })
            setResult(RESULT_OK, Intent() )
            finish()
        }
    }
}