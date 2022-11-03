package at.fh.mappdev.loggingviewsandactivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("MyActivity", "onCreate")
        Log.d("MyActivity", "onCreate")
        Log.i("MyActivity", "onCreate")
        Log.w("MyActivity", "onCreate")
        Log.e("MyActivity", "onCreate")

       // binding.shareMain.setOnClickListener {
        findViewById<Button>(R.id.share_main).setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

        findViewById<Button>(R.id.open_views).setOnClickListener {
            val intent = Intent(this, ViewsActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.open_rating).setOnClickListener {
            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.open_lessons).setOnClickListener {
            val intent = Intent(this, LessonListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.w("MyActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("MyActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MyActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("MyActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("MyActivity", "onDestroy")
    }
}
