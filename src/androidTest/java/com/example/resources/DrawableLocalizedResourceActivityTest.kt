package com.example.resources

import android.content.res.Configuration
import android.content.res.Resources
import android.os.LocaleList
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class DrawableLocalizedResourceActivityTest {

    @Test
    fun testRetrievedAliasDrawableWithChangedLocale() {
        launchActivity<DrawableLocalizedResourceActivity>().use {
            it.onActivity { activity ->
                val expected = ContextCompat.getDrawable(activity, R.drawable.ic_accessibility_new)

                val locale = Locale("fr", "ca")
                Locale.setDefault(locale)
                val res: Resources = activity.resources
                val config: Configuration = res.configuration
                config.setLocales(LocaleList(locale))
                val context = activity.createConfigurationContext(config)

                val actual = ContextCompat.getDrawable(context, R.drawable.ic_accessibility)
                assertTrue(actual!!.toBitmap().sameAs(expected!!.toBitmap()))
            }
        }
    }
}
