package com.example.resources

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ConfigurationChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration_change)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Checks the orientation of the screen
        when {
            newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE -> {
                Snackbar.make(window.decorView, "landscape", Snackbar.LENGTH_SHORT).show()
            }
            newConfig.orientation == Configuration.ORIENTATION_PORTRAIT -> {
                Snackbar.make(window.decorView, "portrait", Snackbar.LENGTH_SHORT).show()
            }
            newConfig.keyboardHidden == Configuration.KEYBOARD_UNDEFINED -> {
                Snackbar.make(window.decorView, "keyboard undefined", Snackbar.LENGTH_SHORT).show()
            }
            newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_NO -> {
                Snackbar.make(window.decorView, "keyboard No", Snackbar.LENGTH_SHORT).show()
            }
            newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_YES -> {
                Snackbar.make(window.decorView, "keyboard Yes", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
