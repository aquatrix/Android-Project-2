/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.Group_17.InstrumentedTesting

import androidx.test.ext.junit.rules.activityScenarioRule
import android.app.Activity
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * The kotlin equivalent to the ChangeTextBehaviorTest, that
 * showcases simple view matchers and actions like [ViewMatchers.withId],
 * [ViewActions.click] and [ViewActions.typeText], and ActivityScenarioRule
 *
 *
 * Note that there is no need to tell Espresso that a view is in a different [Activity].
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test. This is a replacement for
     * [androidx.test.rule.ActivityTestRule].
     */
    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    private val context = ApplicationProvider.getApplicationContext<Context>()


    @Test
    fun changeText_sameActivity() {

        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BE_TYPED)))
    }

    @Test
    fun changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)))
    }



    @Test
//    Validate correct string in TextView in the MainActivity
    fun test1() {
        val input: String = context.getString(R.string.test_text)

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText(input)))
    }

    @Test
//    Enter 123 in editText and press on the Change Text Button and validate the text matches with input
    fun test2() {
        val input: String = context.getString(R.string.text1)

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText(input)))
    }

    @Test
//    Enter 123 in userInput and click on Open Activity and Change Text button and validate the text matches in TextView with input
    fun test3() {
        val input: String = context.getString(R.string.text1)

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())

        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        onView(withId(R.id.show_text_view)).check(matches(withText(input)))
    }

    companion object {

        val STRING_TO_BE_TYPED = "Espresso"
    }
    @Test
//    Without entering anything in userInput clicking on the changeText Button directly and validating TextView with empty string
    fun test4() {
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText("")))
    }
    @Test
//   Without entering anything in userInput clicking on the  Open Activity and Change Text button directly
//   and validating TextView with empty string
    fun test5() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(withText("")))
    }

    @Test
//    Enter abcdef in editText and press on the Change Text Button and validate the text matches with input
    fun test6() {
        val input: String = context.getString(R.string.text2)

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText(input)))
    }

    @Test
//     Enter abcdef in userInput and click on Open Activity and Change Text button
//     and validate the text matches in TextView with input
    fun test7() {
        val input: String = context.getString(R.string.text2)

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(input), closeSoftKeyboard())

        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        onView(withId(R.id.show_text_view)).check(matches(withText(input)))
    }



}