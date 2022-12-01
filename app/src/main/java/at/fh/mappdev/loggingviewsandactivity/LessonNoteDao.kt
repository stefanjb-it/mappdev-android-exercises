package at.fh.mappdev.loggingviewsandactivity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LessonNoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lessonNote: LessonNote)

    @Query("SELECT * FROM LessonNote WHERE id=:id")
    fun findNoteById(id: String): LessonNote

    @Query("SELECT * FROM LessonNote WHERE id=:id")
    fun selectWithLiveData(id: String): LiveData<LessonNote?>
}