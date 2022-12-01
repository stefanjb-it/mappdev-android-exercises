package at.fh.mappdev.loggingviewsandactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel: ViewModel() {

    private val textLiveData = MutableLiveData<String>()

    fun getTextLiveData(): LiveData<String> {
        return textLiveData
    }

    fun addText(text: String) {
        textLiveData.value = text
    }

}