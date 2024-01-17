package com.example.resources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * There is no need to copy resource for all variations.
 *
 * ic_accessibility.xml has alias for two locales, en-rCA and fr-rCA,
 * and ic_accessibility_new will be shown for those two locales
 * instead of ic_accessibility.xml
 *
 * Bitmap resource also can has alias:
 *
 *  <?xml version="1.0" encoding="utf-8"?>
 *       <bitmap xmlns:android="http://schemas.android.com/apk/res/android"
 *       android:src="@drawable/button_0" />
 *
 * String resource also can has alias:
 *
 *  <?xml version="1.0" encoding="utf-8"?>
 *   <resources>
 *       <string name="hello">Hello</string>
 *       <string name="hi">@string/hello</string>
 *   </resources>
 *
 * Color resource also can has alias:
 *
 * <?xml version="1.0" encoding="utf-8"?>
 *   <resources>
 *       <color name="red">#f00</color>
 *       <color name="highlight">@color/red</color>
 *   </resources>
 */
class DrawableLocalizedResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable_localized_resource)
    }
}
