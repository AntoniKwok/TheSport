package com.antoni.wijaya.thesport.ui.detail.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.antoni.wijaya.thesport.R
import org.junit.Rule
import org.junit.Test

class DetailLeagueActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<DetailLeagueActivity>(DetailLeagueActivity::class.java)

    private var wait: Long = 2000

    @Test
    fun check() {
        Thread.sleep(wait)

        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_league_info)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_match)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_match)).perform(click())

        onView(withId(R.id.navigation_team)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_team)).perform(click())

    }

}