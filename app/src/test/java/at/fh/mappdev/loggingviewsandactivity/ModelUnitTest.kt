package at.fh.mappdev.loggingviewsandactivity

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.assertEquals
import org.junit.Test

class ModelUnitTest {

    private val allowableDifference = 0.0001;

    @Test
    fun averageForEmptyRates_isCorrect() {
        //TODO test whether the average is 0.0 when ratings are empty
        val t1:Lesson = Lesson("1111","test","12-12-2022","MAPPDEV",LessonType.LECTURE, listOf(Lecturer("JOHN DOE"),), null,"")
        val avgTest = t1.ratingAverage();
        assertEquals(0.0, avgTest , allowableDifference)
    }
    @Test
    fun averageForNonEmptyRates_isCorrect() {
        //TODO check whether the average is correct for a non-empty list of ratings
        val t1:Lesson = Lesson("1111","test","12-12-2022","MAPPDEV",LessonType.LECTURE, listOf(Lecturer("JOHN DOE"),), mutableListOf<LessonRating>(LessonRating(5.0,""),LessonRating(3.3,""),LessonRating(1.1,"")),"")
        val avgTest = t1.ratingAverage();
        val testAvg = (5.0+3.3+1.1)/3;
        assertEquals(testAvg, avgTest , allowableDifference)
    }
}