package com.antoni.wijaya.thesport.ui.home.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.antoni.wijaya.thesport.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

    private var wait: Long = 2000

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(wait)
        onView(withId(R.id.rv_league))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_league)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                1
            )
        )

    }

}