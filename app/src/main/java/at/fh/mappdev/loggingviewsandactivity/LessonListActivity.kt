package at.fh.mappdev.loggingviewsandactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi

class LessonListActivity : AppCompatActivity() {

    private val viewModel: LessonListViewModel by viewModels()

    val lessonAdapter = LessonAdapter() { /*Toast.makeText(this, "Lesson with name: ${it.name} has been clicked", Toast.LENGTH_LONG).show()*/
        val intent = Intent(this,LessonRatingActivity::class.java)
        intent.putExtra(EXTRA_LESSON_ID,it.id)
        startActivityForResult(intent,ADD_OR_EDIT_RATING_REQUEST)
    }

    companion object {
        val ADD_OR_EDIT_RATING_REQUEST = 1
        val EXTRA_LESSON_ID = "LESSON_ID_EXTRA"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == RESULT_OK) {
            /*viewModel.refresh(
                success = {
                    lessonAdapter.updateList(it)
                },
                error = {
                    lessonAdapter.updateList(emptyList())
                    Toast.makeText(applicationContext,"Couldn't load lessons from API!",Toast.LENGTH_SHORT).show()
                }
            )*/
            viewModel.refresh()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)
        /* LessonRepository.lessonsList(
            success = {
                lessonAdapter.updateList(it)
            },
            error = {
                lessonAdapter.updateList(emptyList())
                Toast.makeText(applicationContext,"Couldn't load lessons from API!",Toast.LENGTH_SHORT).show()
            }
        )*/

        viewModel.lessons.observe(this){
            when(it){
                is NetworkResult.NetworkSuccess -> {
                    lessonAdapter.updateList(it.value)
                }
                is NetworkResult.NetworkError -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }


        val recyclerView = findViewById<RecyclerView>(R.id.lesson_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lessonAdapter
        parseJson()
        SleepyAsyncTask().execute()
    }

    fun parseJson() {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter<Lesson>(Lesson::class.java)
        val json = """
            {
                "id": "1",
                "name": "Lecture 0",
                "date": "09.10.2019",
                "topic": "Introduction",
                "type": "LECTURE",
                "lecturers": [
                    {
                        "name": "Lukas Bloder"
                    },
                    {
                        "name": "Peter Salhofer"
                    }
                ],
                "ratings": [],
                "imageUrl": ""
            }
        """
        val result = jsonAdapter.fromJson(json)
        println("DISSECTED RESULT: "+result?.name)
    }
}