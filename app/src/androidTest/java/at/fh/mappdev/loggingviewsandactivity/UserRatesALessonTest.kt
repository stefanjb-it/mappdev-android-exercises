package at.fh.mappdev.loggingviewsandactivity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserRatesALessonTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }
    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun clickingLessonsButton_searchLesson_clickLesson_shouldLaunchLessonRatingActivity() {
        Thread.sleep(2000)
        onView(withId(R.id.open_lessons)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(LessonListActivity::class.java.name))
        Thread.sleep(2000)
        onView(withId(R.id.lesson_recycler_view)).perform(RecyclerViewActions.actionOnItem<LessonViewHolder>(hasDescendant(withText("Lecture 0")), click()))
        Intents.intended(IntentMatchers.hasComponent(LessonRatingActivity::class.java.name))
        Thread.sleep(2000)
        onView(withId(R.id.lesson_rating_header)).check(ViewAssertions.matches(withText("Lecture 0")))
        onView(withId(R.id.rate_lesson)).perform(click())
    }


}