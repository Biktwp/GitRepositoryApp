package com.optiva.yks.presentation.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.optiva.yks.R
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, false, false)


    @BeforeAll
    fun setUp(){

        activityRule.launchActivity(null)
    }



    @Test
    fun appLaunchesSuccessfully() {

        activityRule.activity

        onView(withId(R.id.container)).check(matches(isDisplayed()))

        //activityRule.launchActivity(null)
    }

//    @Test
//    fun onLaunchCheckAmountInputIsDisplayed() {
//        // 1
//        activityRule.activity
//        //activityRule.launchActivity(null)
//        // 2
//        onView(withId(R.id.container))
//            // 3
//            .check(matches(isDisplayed()))
//    }

}