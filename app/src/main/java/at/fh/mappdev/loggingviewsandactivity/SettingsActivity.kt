package at.fh.mappdev.loggingviewsandactivity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val SharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        findViewById<EditText>(R.id.textInputEditText_Username).setText(SharedPreferences.getString("USERNAME", CreationSharedPreferences.USERNAME))
        findViewById<Switch>(R.id.sw_darkmode).isChecked =
            SharedPreferences.getBoolean("DARKMODE", CreationSharedPreferences.DARKMODE)

        findViewById<Button>(R.id.btn_saveSettings).setOnClickListener {
            val SharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
            SharedPreferences.edit().putString("USERNAME",findViewById<EditText>(R.id.textInputEditText_Username).text.toString()).apply()
            SharedPreferences.edit().putBoolean("DARKMODE",findViewById<Switch>(R.id.sw_darkmode).isChecked).apply()
            if (SharedPreferences.getBoolean("DARKMODE", CreationSharedPreferences.DARKMODE)) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            finish()
        }
    }

    companion object CreationSharedPreferences {
        val USERNAME = "USERNAME"
        val DARKMODE = false
    }
}