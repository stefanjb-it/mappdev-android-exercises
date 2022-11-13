package at.fh.mappdev.loggingviewsandactivity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LessonRating(val ratingValue:Double, val feedback:String) {

}