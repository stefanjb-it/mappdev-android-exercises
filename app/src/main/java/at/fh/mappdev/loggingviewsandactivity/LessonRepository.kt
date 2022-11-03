package at.fh.mappdev.loggingviewsandactivity

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
                mutableListOf()
            ),
            Lesson("1",
                "Lecture 1",
                "02.10.2020",
                "Go2Kotlin",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf()
            ),
            Lesson("2",
                "Exercise 1",
                "05.10.2020",
                "Go2Kotlin",
                LessonType.PRACTICAL,
                listOf( lecturerSalhofer ),
                mutableListOf()
            ),
            Lesson("3",
                "Lecture 2",
                "12.10.2020",
                "Go2Kotlin-OOP",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf()
            ),
            Lesson("4",
                "Exercise 2",
                "13.10.2020",
                "Go2Kotlin-OOP",
                LessonType.PRACTICAL,
                listOf( lecturerSalhofer ),
                mutableListOf()
            ),
            Lesson("5",
                "Lecture 3",
                "23.10.2020",
                "SCM",
                LessonType.LECTURE,
                listOf( lecturerSalhofer ),
                mutableListOf()
            ),
            Lesson("6",
                "Lecture 4",
                "23.10.2020",
                "Android Basics",
                LessonType.LECTURE,
                listOf( lecturerBloder ),
                mutableListOf( )
            ),
            Lesson("7",
                "Exercise 4",
                "29.10.2020",
                "Android Basics",
                LessonType.PRACTICAL,
                listOf( lecturerBloder ),
                mutableListOf()
            ),
            Lesson("8",
                "Lecture 5",
                "11.11.2020",
                "Recycler View",
                LessonType.LECTURE,
                listOf( lecturerBloder ),
                mutableListOf()
            ),
            Lesson("9",
                "Exercise 5",
                "13.11.2020",
                "Android Basics",
                LessonType.PRACTICAL,
                listOf( lecturerBloder ),
                mutableListOf()
            )
        )
    }

    fun lessonsList(): List<Lesson> {
        return lessons
    }

    fun lessonById(id: String): Lesson? {
        return lessons.find { it.id == id }
    }

    fun rateLesson(id: String, rating: LessonRating) {
        // TODO ADD Rating to lesson
    }
}