package at.fh.mappdev.loggingviewsandactivity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LessonNote(@PrimaryKey val id: String, val lessonName: String, val text: String) {

}