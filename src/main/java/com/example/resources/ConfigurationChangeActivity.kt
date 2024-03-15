package com.example.resources

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resources.databinding.ActivityConfigurationChangeBinding

class ConfigurationChangeActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityConfigurationChangeBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigurationChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Checks the orientation of the screen
        when {
            newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE -> {
                binding.text.text = "landscape"
            }
            newConfig.orientation == Configuration.ORIENTATION_PORTRAIT -> {
                binding.text.text = "portrait"
            }
            newConfig.keyboardHidden == Configuration.KEYBOARD_UNDEFINED -> {
                binding.text.text = "keyboard undefined"
            }
            newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_NO -> {
                binding.text.text = "keyboard No"
            }
            newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_YES -> {
                binding.text.text = "keyboard Yes"
            }
        }
    }
}
