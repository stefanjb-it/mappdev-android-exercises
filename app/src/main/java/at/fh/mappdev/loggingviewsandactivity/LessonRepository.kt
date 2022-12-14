package at.fh.mappdev.loggingviewsandactivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Response.success

object LessonRepository {
    private val lessons: List<Lesson>

    init {
        val lecturerSalhofer = Lecturer("Peter Salhofer")
        val lecturerBloder = Lecturer("Lukas Bloder")
        lessons = listOf(
            Lesson("0",
                "Lecture 0",
                "01.10.2020",
                "Introduction",
                LessonType.LECTURE,
                listOf( lecturerSalhofer, lecturerBloder ),
                mutableListOf(),
                ""
            ),
            Lesson("1",
                "Lecture 1",
                "02.10.2020",
                "Go2Kotlin",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf(),
                ""
            ),
            Lesson("2",
                "Exercise 1",
                "05.10.2020",
                "Go2Kotlin",
                LessonType.PRACTICAL,
                listOf( lecturerSalhofer ),
                mutableListOf(),
                ""
            ),
            Lesson("3",
                "Lecture 2",
                "12.10.2020",
                "Go2Kotlin-OOP",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf(),
                ""
            ),
            Lesson("4",
                "Exercise 2",
                "13.10.2020",
                "Go2Kotlin-OOP",
                LessonType.PRACTICAL,
                listOf( lecturerSalhofer ),
                mutableListOf(),
                ""
            ),
            Lesson("5",
                "Lecture 3",
                "23.10.2020",
                "SCM",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf(),
                ""
            ),
            Lesson("6",
                "Lecture 4",
                "23.10.2020",
                "Android Basics",
                LessonType.LECTURE,
                listOf( lecturerBloder ),
                mutableListOf( ),
                ""
            ),
            Lesson("7",
                "Exercise 4",
                "29.10.2020",
                "Android Basics",
                LessonType.PRACTICAL,
                listOf( lecturerBloder ),
                mutableListOf(),
                ""
            ),
            Lesson("8",
                "Lecture 5",
                "11.11.2020",
                "Recycler View",
                LessonType.LECTURE,
                listOf( lecturerBloder ),
                mutableListOf(),
                ""
            ),
            Lesson("9",
                "Exercise 5",
                "13.11.2020",
                "Android Basics",
                LessonType.PRACTICAL,
                listOf( lecturerBloder ),
                mutableListOf(),
                ""
            )
        )
    }

    fun lessonsList(success: (lessonList: List<Lesson>) -> Unit, error: (errorMessage: String) -> Unit) {
        LessonApi.retrofitService.lessons().enqueue(object: Callback<List<Lesson>> {
            override fun onFailure(call: Call<List<Lesson>>, t: Throwable) {
                error("The call failed")
            }

            override fun onResponse(call: Call<List<Lesson>>, response: Response<List<Lesson>>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }
        })
    }

    fun lessonById(id: String, success: (lesson: Lesson) -> Unit, error: (errorMessage: String) -> Unit) {
        LessonApi.retrofitService.getLessonById(id).enqueue(object: Callback<Lesson> {
            override fun onFailure(call: Call<Lesson>, t: Throwable) {
                error("The call failed")
            }

            override fun onResponse(call: Call<Lesson>, response: Response<Lesson>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null){
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }
        })
    }

    fun rateLesson(id: String, rating: LessonRating, success: (outcome: String) -> Unit) {
        LessonApi.retrofitService.rateLesson(id, rating).enqueue(object: Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                success("success")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                error("Something went wrong")
            }
        })
    }

    fun addLessonNote(context: Context, lessonNote: LessonNote) {
        val applicationContext = context.applicationContext
        val db = LessonNoteDatabase.getDatabase(applicationContext)
        db.lessonNoteDao.insert(lessonNote)
    }

    fun findLessonNoteById(context: Context, id: String) : LessonNote?{
        val applicationContext = context.applicationContext
        val db = LessonNoteDatabase.getDatabase(applicationContext)
        return db.lessonNoteDao.findNoteById(id)
    }

    fun findLessonNoteByIdLiveData(context: Context, id: String) : LiveData<LessonNote?> {
        val applicationContext = context.applicationContext
        val db = LessonNoteDatabase.getDatabase(applicationContext)
        return db.lessonNoteDao.selectWithLiveData(id)
    }
    fun lessonsListWithLiveData(): LiveData<NetworkResult<List<Lesson>>> {
        val liveData = MutableLiveData<NetworkResult<List<Lesson>>>()
        LessonApi.retrofitService.lessons().enqueue(object : Callback<List<Lesson>> {
            override fun onFailure(call: Call<List<Lesson>>, t: Throwable) {
                liveData.value = NetworkResult.NetworkError("Something went wrong")
            }

            override fun onResponse(call: Call<List<Lesson>>, response: Response<List<Lesson>>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    liveData.value = NetworkResult.NetworkSuccess(responseBody)
                } else {
                    liveData.value = NetworkResult.NetworkError("Something went wrong")
                }
            }

        })
        return liveData
    }
}