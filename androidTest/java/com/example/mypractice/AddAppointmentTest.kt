package com.example.mypractice
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class AddAppointmentTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(AddAppointment::class.java)

    @Test
    fun testSelectDateButton_Clicked() {
        onView(withId(R.id.btnSelDate)).perform(click())
    }

    @Test
    fun testSelectTimeButton_Clicked() {
        onView(withId(R.id.btnSelTime)).perform(click())
    }

    @Test
    fun testCreateAppointmentButton_Clicked() {
        onView(withId(R.id.btnCreateApp)).perform(click())
    }

    @Test
    fun testBackButton_Clicked() {
        onView(withId(R.id.imBack)).perform(click())
    }
}