package com.antoni.wijaya.thesport.ui.match.search

import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.antoni.wijaya.thesport.R
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test


class SearchMatchActivityTest {

    companion object {
        const val SEARCH_STR = "arsenal"
    }

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<SearchMatchActivity>(SearchMatchActivity::class.java)

    private var wait: Long = 2000


    @Test
    fun testMatchNotFound() { // Click on the search icon
        Thread.sleep(wait)
        onView(withId(R.id.search_view)).check(matches(isDisplayed()))
        onView(withId(R.id.search_view)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText("No Data"),
            pressImeActionButton()
        )
        onView(withId(R.id.icon_back)).check(matches(isDisplayed()))
    }

    @Test
    fun testMatchFound() {
        Thread.sleep(wait)
        onView(withId(R.id.search_view)).check(matches(isDisplayed()))
        onView(isAssignableFrom(EditText::class.java)).perform(clearText())
        onView(withId(R.id.search_view)).perform(click())
        onView(isAssignableFrom(EditText::class.java)).perform(
            typeText(SEARCH_STR),
            pressImeActionButton()
        )

        onView(withId(R.id.icon_back)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_match_not_found)).check(matches(not(isDisplayed())))
    }
}