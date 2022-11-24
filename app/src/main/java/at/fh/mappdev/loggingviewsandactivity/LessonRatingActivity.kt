package at.fh.mappdev.loggingviewsandactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import java.math.RoundingMode
import java.text.DecimalFormat

class LessonRatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_rating)
        val id =  intent.getStringExtra(LessonListActivity.EXTRA_LESSON_ID)
        if (id == null) {
            return;
        } else{
            LessonRepository.lessonById(id, { lesson ->
                findViewById<TextView>(R.id.lesson_rating_header).text = lesson.name
                findViewById<RatingBar>(R.id.avg_lesson_rating_bar).rating = lesson.ratingAverage().toFloat()

                val df = DecimalFormat("#.####")
                df.roundingMode = RoundingMode.DOWN
                val roundoff = df.format(lesson.ratingAverage())
                findViewById<TextView>(R.id.avg_lesson_rating_value).text = roundoff

                for (lessonrating in lesson.ratings){
                    if (lessonrating.feedback != ""){
                        findViewById<TextView>(R.id.lesson_rating_last_feedback).text = lessonrating.feedback
                        break
                    }
                }

                val imageView = this.findViewById<ImageView>(R.id.lesson_image)
                Glide
                    .with(this)
                    .load(lesson.imageUrl)
                    .into(imageView)
                findViewById<Button>(R.id.btn_openNote).setOnClickListener {
                    val intent = Intent(this, LessonNoteActivity::class.java);
                    intent.putExtra("name", lesson.name)
                    intent.putExtra("id", lesson.id)
                    startActivity(intent)
                }

            }, { errorMessage ->
                findViewById<TextView>(R.id.lesson_rating_header).text = errorMessage

            })

        }
        findViewById<Button>(R.id.rate_lesson).setOnClickListener {
            LessonRepository.rateLesson(
                id,
                LessonRating(findViewById<RatingBar>(R.id.lesson_rating_bar).rating.toDouble(),
                    findViewById<TextView>(R.id.lesson_feedback).text.toString()),
            success = {
            })
            setResult(RESULT_OK, Intent() )
            finish()
        }
    }
}