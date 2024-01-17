package com.example.resources

import android.icu.text.Transliterator
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Date
import java.util.Locale

class InternationalizationResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internationalization_resource)

        val skeleton: String = if (DateFormat.is24HourFormat(this)) "Hm" else "hm"
        val formattedTime = android.icu.text.DateFormat.getInstanceForSkeleton(
            skeleton,
            Locale.getDefault()
        ).format(
            Date()
        )

        findViewById<TextView>(R.id.text).text = formattedTime

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val availableIDs = Transliterator.getAvailableIDs()
            val transliterate = StringBuilder()
            for (availableID in availableIDs) {
                println("AAA $availableID")
                with(Transliterator.getInstance(availableID)) {
                    transliterate
                        .append(availableID)
                        .append("-")
                        .append(this.transliterate("Привіт!")) // Ukrainian-Latin/BGN
                        .append("\n")
                }
            }
            findViewById<TextView>(R.id.text2).text = transliterate
        }
    }
}
