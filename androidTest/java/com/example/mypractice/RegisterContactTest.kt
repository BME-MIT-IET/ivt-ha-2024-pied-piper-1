package com.example.mypractice

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertTrue


@RunWith(AndroidJUnit4ClassRunner::class)
class RegisterContactTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(Login::class.java)


    @Before
    fun setUp() {
        Intents.init() // Initialize intents
        onView(withId(R.id.tvRegister)).perform(click())
        Thread.sleep(1000)
    }

    @After
    fun tearDown() {
        Intents.release() // Clean up after each test
    }

    @Test
    fun testRegisterInputAccepted() {
        onView(withId(R.id.etName)).perform(click(), typeText("John"))
        onView(withId(R.id.etEmail)).perform(click(), typeText("johndoe@email.com"))
        onView(withId(R.id.etNumber)).perform(click(), typeText("1234567890"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnNext)).perform(click())

        // Assert that the expected Intent was fired to start RegisterID activity
        Thread.sleep(1000)
        Intents.intended(hasComponent(RegisterID::class.java.name))

    }

    // Invalid email address
    @Test
    fun testRegisterInputRejected() {
        onView(withId(R.id.etName)).inRoot(RootMatchers.isFocusable()).perform(click(), typeText("John Doe"))
        onView(withId(R.id.etEmail)).inRoot(RootMatchers.isFocusable()).perform(click(), typeText("invalid-email"))
        onView(withId(R.id.etNumber)).inRoot(RootMatchers.isFocusable()).perform(click(), typeText("1234567890"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnNext)).inRoot(RootMatchers.isFocusable()).perform(click())

        Thread.sleep(1000)
        // Check if specific elements are still displayed, indicating we're still on the same activity
        onView(withId(R.id.etEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.etNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.btnNext)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackNavigation() {
        onView(withId(R.id.imBack)).perform(click())
        Thread.sleep(1000)

        
        // Check if the email field is displayed, ensuring you're back at the Login activity
        onView(withId(R.id.etEmail)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))

        // Additionally, check for the presence of both the login button and the registration text,
        // which are unique to the Login activity
        onView(withId(R.id.btnLogin)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))
        onView(withId(R.id.tvRegister)).inRoot(RootMatchers.isFocusable()).check(matches(isDisplayed()))
    }



}
