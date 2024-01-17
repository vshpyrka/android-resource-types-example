package com.example.resources.types

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resources.databinding.ActivityResourceTypeColorStateListBinding

/**
 * Actions which change state:
 *      touch action down
 *      touch action up
 *      keyboard arrow click
 *      scroll status bar
 *      dpad focus change
 */
class ResourceTypeColorStateListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResourceTypeColorStateListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view.setOnFocusChangeListener { _, hasFocus ->
            println("View has focus - $hasFocus")
        }
        binding.view.setOnClickListener {  }

        val colorStates = arrayOf(
            intArrayOf(-android.R.attr.state_focused, android.R.attr.state_pressed),
            intArrayOf(-android.R.attr.state_focused, -android.R.attr.state_pressed),
            intArrayOf(android.R.attr.state_focused)
        )

        val colorStateList = ColorStateList(
            colorStates,
            intArrayOf(
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.parseColor("#ff000000"),
            )
        )

        binding.view2.backgroundTintList = colorStateList
        binding.view2.setOnClickListener {  }
    }
}
