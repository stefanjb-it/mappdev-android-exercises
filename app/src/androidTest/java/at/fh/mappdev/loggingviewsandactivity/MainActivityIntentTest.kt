package at.fh.mappdev.loggingviewsandactivity

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityIntentTest {
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
    fun clickingLessonsButton_shouldLaunchLessonListActivity() {
        onView(withId(R.id.open_lessons)).perform(click())
        intended(hasComponent(LessonListActivity::class.java.name))
    }
    @Test
    fun clickingViewsButton_shouldLaunchViewsActivity() {
        onView(withId(R.id.open_views)).perform(click())
        intended(hasComponent(ViewsActivity::class.java.name))
    }
    @Test
    fun clickingRatingButton_shouldLaunchRatingActivity() {
        onView(withId(R.id.open_rating)).perform(click())
        intended(hasComponent(RatingActivity::class.java.name))
    }
    @Test
    fun clickingShareButton_shouldLaunchShare() {
        onView(withId(R.id.share_main)).perform(click())
        intended(hasAction(Intent.ACTION_CHOOSER))
    }
}