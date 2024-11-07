package com.example.assignment2

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AutomatedUITest {

    @Test
    fun useAutomatedUI(){
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        //Navigating home
        device.pressHome()
        //Finding app
        val app: UiObject2 = device.findObject(By.text("Assignment2"))
        //Perform a click and wait until the app is opened.
        val opened: Boolean = app.clickAndWait(Until.newWindow(), 20000)
        assertEquals(true,opened)
        //Waiting until the app is open
        device.wait(
            Until.hasObject(By.pkg("com.example.assignment2").depth(0)),
            20000
        )
        //Clicking button to start activity
        val button: UiObject2 = device.findObject(By.text("Start Activity Explicitly"))
        val clicked: Boolean = button.clickAndWait(Until.newWindow(), 20000)
        assertEquals(true,clicked)
        //Waiting until the page is navigated to
        device.waitForIdle()
        //Finding software engineering challenge element
        val challengeEl = By.text("Device and OS Fragmentation")
        //Waiting until element is found
        device.wait(Until.hasObject(challengeEl),20000)
        val exists = device.hasObject(challengeEl)
        assertEquals(true,exists)

    }
}