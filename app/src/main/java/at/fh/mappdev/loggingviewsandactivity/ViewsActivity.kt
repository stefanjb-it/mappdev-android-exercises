package at.fh.mappdev.loggingviewsandactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        Log.w("MyViewsActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.w("MyViewsActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w("MyViewsActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w("MyViewsActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.w("MyViewsActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("MyViewsActivity", "onDestroy")
    }
}
