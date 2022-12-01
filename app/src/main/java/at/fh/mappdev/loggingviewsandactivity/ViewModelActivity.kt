package at.fh.mappdev.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

class ViewModelActivity : AppCompatActivity() {

    private val viewModel: ViewModelActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        viewModel.getTextLiveData().observe(this) {
            findViewById<TextView>(R.id.livedata_text).text = it
        }
        findViewById<Button>(R.id.livedata_button).setOnClickListener {
            viewModel.addText(findViewById<EditText>(R.id.livedata_text_input).text.toString())
        }
    }
}