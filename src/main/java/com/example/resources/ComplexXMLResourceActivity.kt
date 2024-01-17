package com.example.resources

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * Check if animations are enabled in Developer options
 *
 * If the vector drawable and animations are re-used in multiple places,
 * avd.xml example is the best way to implement an animated vector drawable.
 *
 * If they’re only ever used for this animated vector drawable,
 * then avd2.xml is a more compact way to implement them.
 *
 * The XML tag <aapt:attr > tells AAPT that the tag’s child shall be
 * treated as a resource and extracted into its own resource file.
 *
 * The value in the attribute name specifies where to use the inline
 * resource within the parent tag.
 */
class ComplexXMLResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complex_xmlresourxe)

        val image = findViewById<ImageView>(R.id.image)
        (image.drawable as AnimatedVectorDrawable).start()
    }
}
