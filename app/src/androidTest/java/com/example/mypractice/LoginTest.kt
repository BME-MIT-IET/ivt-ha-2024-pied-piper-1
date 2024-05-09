package com.example.mypractice

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginTest
{
    @get:Rule
    val activityRule = ActivityScenarioRule(Login::class.java)

    @Test
    fun testLoginSuccess() {
        onView(withId(R.id.etEmail)).perform(typeText("jlo@gmail.com"))
        onView(withId(R.id.etPassword)).perform(typeText("1!mypassword"))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.tvGreeting)).check(matches(isDisplayed()))

//        onView(withText("Invalid login details, please try again")).inRoot(ToastMatcher())
//            .check(matches(isDisplayed()))
    }
}