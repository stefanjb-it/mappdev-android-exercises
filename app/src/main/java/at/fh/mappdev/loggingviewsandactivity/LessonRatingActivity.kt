package at.fh.mappdev.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        findViewById<TextView>(R.id.lesson_rating_header).text =
            LessonRepository.lessonById(id)?.name ?: "UNKNOWN"

    }
}