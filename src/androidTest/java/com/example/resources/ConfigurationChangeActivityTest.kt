package com.example.resources

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.device.DeviceInteraction.Companion.setScreenOrientation
import androidx.test.espresso.device.EspressoDevice.Companion.onDevice
import androidx.test.espresso.device.action.ScreenOrientation
import androidx.test.espresso.device.rules.ScreenOrientationRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.FlakyTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConfigurationChangeActivityTest {

    @get:Rule
    val screenOrientationRule: ScreenOrientationRule =
        ScreenOrientationRule(ScreenOrientation.PORTRAIT)


    @FlakyTest
    @Test
    fun testConfigurationChange() {
        launchActivity<ConfigurationChangeActivity>().use { scenario ->
            val context = ApplicationProvider.getApplicationContext<Context>()
            val instrumentation = getInstrumentation()
            val uiDevice = UiDevice.getInstance(instrumentation)
            // Rotate device
            uiDevice.setOrientationLeft()
            Espresso.onView(ViewMatchers.withId(R.id.text))
                .check(ViewAssertions.matches(ViewMatchers.withText("landscape")))
            // Rotate device back
            uiDevice.unfreezeRotation()
            // Wait for screen to reappear
            uiDevice.waitForWindowUpdate(context.packageName, 3000)
            Espresso.onView(ViewMatchers.withId(R.id.text))
                .check(ViewAssertions.matches(ViewMatchers.withText("portrait")))
            // Close
            Espresso.pressBackUnconditionally()
            Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        }
    }

    /*
    @Test
    fun testConfigurationChangeNew() {
        launchActivity<ConfigurationChangeActivity>().use { scenario ->
            // Sets the device to landscape orientation during test execution.
            onDevice().setScreenOrientation(ScreenOrientation.LANDSCAPE)

            Espresso.onView(ViewMatchers.withId(R.id.text))
                .check(ViewAssertions.matches(ViewMatchers.withText("landscape")))

            onDevice().setScreenOrientation(ScreenOrientation.PORTRAIT)

            Espresso.onView(ViewMatchers.withId(R.id.text))
                .check(ViewAssertions.matches(ViewMatchers.withText("portrait")))
            // Close
            Espresso.pressBackUnconditionally()
            Truth.assertThat(scenario.state).isEqualTo(Lifecycle.State.DESTROYED)
        }
    }

     */
}
