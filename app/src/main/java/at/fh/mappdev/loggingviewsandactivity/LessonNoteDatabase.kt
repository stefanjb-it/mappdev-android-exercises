package at.fh.mappdev.loggingviewsandactivity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LessonNote::class], version = 1)
abstract class LessonNoteDatabase : RoomDatabase() {
    abstract val lessonNoteDao: LessonNoteDao

    companion object {
        private var INSTANCE: LessonNoteDatabase? = null
        fun getDatabase(context: Context): LessonNoteDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): LessonNoteDatabase {
            return Room.databaseBuilder(
                context,
                LessonNoteDatabase::class.java, "lesson-note-db"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}