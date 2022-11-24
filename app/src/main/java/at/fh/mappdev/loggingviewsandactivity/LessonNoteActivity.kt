package at.fh.mappdev.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LessonNoteActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_note)
        findViewById<TextView>(R.id.textView_lessonName).text = intent.getStringExtra("name")
        findViewById<EditText>(R.id.editTextTextMultiLine_note).setText(LessonRepository.findLessonNoteById(this, intent.getStringExtra("id")!!)?.text)
        findViewById<Button>(R.id.btn_saveNote).setOnClickListener {
            val lessonNote = LessonNote(intent.getStringExtra("id").toString(), intent.getStringExtra("name").toString(), findViewById<EditText>(R.id.editTextTextMultiLine_note).text.toString())
            LessonRepository.addLessonNote(this, lessonNote)
            findViewById<EditText>(R.id.editTextTextMultiLine_note).setText(LessonRepository.findLessonNoteById(this, intent.getStringExtra("id")!!)?.text)
        }
    }
}