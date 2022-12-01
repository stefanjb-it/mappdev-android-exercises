package at.fh.mappdev.loggingviewsandactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LessonListViewModel: ViewModel() {
    private val loadTrigger = MutableLiveData(Unit)
    val lessons = Transformations.switchMap(loadTrigger) {
        LessonRepository.lessonsListWithLiveData()
    }
    fun refresh() {
        loadTrigger.value = Unit
    }
}