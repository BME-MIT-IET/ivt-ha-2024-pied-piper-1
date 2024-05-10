package com.example.mypractice

import android.widget.DatePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matchers
import androidx.test.espresso.UiController
import org.hamcrest.Matcher
import android.view.View
import android.widget.TimePicker


@RunWith(AndroidJUnit4ClassRunner::class)
class AddAppointmentTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Login::class.java)

    @Before
    fun setUp() {
        Intents.init() // Initialize intents
        onView(withId(R.id.etEmail)).perform(click())
        onView(withId(R.id.etEmail)).perform(ViewActions.typeText("jlo@gmail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.etPassword)).perform(click())
        onView(withId(R.id.etPassword)).perform(ViewActions.typeText("1!mypassword"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.nav_appointments)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.btnAddNew)).perform(click())
        Thread.sleep(1000)
    }

    @After
    fun tearDown() {
        Intents.release() // Clean up after each test
    }

    @Test
    fun testAppointmentCreationFlowCorrect() {
        // Selecting a patient
        onView(withId(R.id.spinClients))
            .perform(/*scrollTo(),*/ click())
        Thread.sleep(1000)

        // Interact with the spinner's data
        onData(anything()).atPosition(0)
            .inRoot(RootMatchers.isPlatformPopup()) // Use this to ensure you're interacting with the spinner's popup content
            .perform(click())
        Thread.sleep(1000)

        // Selecting date
        // Click to show DatePickerDialog
        onView(withId(R.id.btnSelDate)).perform(click())
        Thread.sleep(1000) // Wait for the dialog to appear

        // Directly interact with the DatePicker widget
        onView(withClassName(Matchers.equalTo(DatePicker::class.java.name))).perform(object :
            ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(DatePicker::class.java)
            }

            override fun getDescription(): String {
                return "Set the date on DatePicker"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val datePicker = view as DatePicker
                datePicker.updateDate(2024, 6, 15) // Month is 0-based in Calendar API
            }
        })
        onView(withText("OK")).perform(click()) // Confirm the date
        Thread.sleep(1000)

        // Selecting time
        // Click to show TimePickerDialog
        onView(withId(R.id.btnSelTime)).perform(click())
        Thread.sleep(1000) // Wait for the dialog to appear

        // Directly interact with the TimePicker widget
        onView(withClassName(Matchers.equalTo(TimePicker::class.java.name))).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TimePicker::class.java)
            }

            override fun getDescription(): String {
                return "Set the time on TimePicker"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val timePicker = view as TimePicker
                timePicker.currentHour = 10 // Set hour to 10
                timePicker.currentMinute = 45 // Set minute to 45
            }
        })
        onView(withText("OK")).perform(click()) // Confirm the time

        Thread.sleep(1000)


        // Proceed with further steps assuming date/time are not set
        onView(withId(R.id.btnCreateApp)).perform(click())
        Thread.sleep(1000)

        // Check that Add Appointment was successful
        // Checking back at the Appointments activity
        onView(withId(R.id.tvDate)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))
        onView(withId(R.id.tvDayofWeek)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))
    }

    @Test   // No date and time input
    fun testAppointmentCreationFlowError() {
        // Selecting a patient
        onView(withId(R.id.spinClients))
            .perform(/*scrollTo(),*/ click())
        Thread.sleep(1000)

        // Interact with the spinner's data
        onData(anything()).atPosition(0)
            .inRoot(RootMatchers.isPlatformPopup()) // Use this to ensure you're interacting with the spinner's popup content
            .perform(click())
        Thread.sleep(1000)

        // Proceed with further steps assuming date/time are not set
        onView(withId(R.id.btnCreateApp)).perform(click())
        Thread.sleep(1000)

        // Check that Add Appointment was not left
        onView(withId(R.id.btnCreateApp)).check(matches(isDisplayed()))

    }

    @Test
    fun testBackNavigation() {
        onView(withId(R.id.imBack)).perform(click())
        Thread.sleep(1000)

        // Ensure the dialog appears and click 'Yes' to confirm discarding changes
        onView(withText("Yes")).inRoot(isDialog()).check(matches(isDisplayed())).perform(click())
        Thread.sleep(1000)

        // Checking back at the Appointments activity
        onView(withId(R.id.tvDate)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))
        onView(withId(R.id.tvDayofWeek)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))

    }
}
