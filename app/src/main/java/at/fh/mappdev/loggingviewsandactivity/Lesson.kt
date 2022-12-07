package at.fh.mappdev.loggingviewsandactivity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Lesson(
    val id: String, val name: String, val date: String, val topic: String,
    val type: LessonType, val lecturers: List<Lecturer>, val ratings: MutableList<LessonRating>?, val imageUrl: String
) {
    fun ratingAverage(): Double {
        return ratings?.let {
            it.sumOf { it.ratingValue } / it.count()
        }?: 0.0
    }
}
