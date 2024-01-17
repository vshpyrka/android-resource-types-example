package com.example.resources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * android:supportsRtl - AndroidManifest.xml flag. Declares whether your application is willing to support right-to-left (RTL) layouts.
 * layout-ldrtl - "layout-direction-right-to-left", default implicit value, generic layout for any other "right-to-left" language (like Persian or Hebrew)
 * layout-ar - specific layout for the Arabic language
 */
class RTLResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rtl_resource)
    }
}
