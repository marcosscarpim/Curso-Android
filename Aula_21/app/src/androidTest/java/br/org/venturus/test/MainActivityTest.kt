package br.org.venturus.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun test_AllComponentsAreVisible() {
        onView(withId(R.id.edittext_first)).check(matches(isDisplayed()))
        onView(withId(R.id.edittext_second)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_result)).check(matches(isDisplayed()))
        onView(withId(R.id.button_add)).check(matches(isDisplayed()))
        onView(withId(R.id.button_sub)).check(matches(isDisplayed()))
        onView(withId(R.id.button_divide)).check(matches(isDisplayed()))
    }

    @Test
    fun test_checkSumButtonIsWorking() {
        val first = "2"
        val second = "3"
        val assertText = "5"

        onView(withId(R.id.edittext_first)).perform(typeText(first))
        onView(withId(R.id.edittext_second)).perform(typeText(second))
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.textview_result)).check(matches(withText(assertText)))
    }

    @Test
    fun test_checkSubButtonIsWorking() {
        val first = "2"
        val second = "3"
        val assertText = "-1"

        onView(withId(R.id.edittext_first)).perform(typeText(first))
        onView(withId(R.id.edittext_second)).perform(typeText(second))
        onView(withId(R.id.button_sub)).perform(click())
        onView(withId(R.id.textview_result)).check(matches(withText(assertText)))
    }

    @Test
    fun test_checkDivideButtonIsWorking() {
        val first = "1"
        val second = "2"
        val assertText = "0.5"

        onView(withId(R.id.edittext_first)).perform(typeText(first))
        onView(withId(R.id.edittext_second)).perform(typeText(second))
        onView(withId(R.id.button_divide)).perform(click())
        onView(withId(R.id.textview_result)).check(matches(withText(assertText)))
    }

    @Test
    fun test_whenNoDataIsInsertedThenButtonsDoesntWork() {
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.button_sub)).perform(click())
        onView(withId(R.id.button_divide)).perform(click())
        onView(withId(R.id.textview_result)).check(matches(withText("")))
    }
}